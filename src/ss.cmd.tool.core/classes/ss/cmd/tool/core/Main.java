/*
 * The MIT License
 *
 * Copyright 2021 alex.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ss.cmd.tool.core;

import java.lang.System.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import ss.cmd.tool.core.api.CommandProvider;
import ss.cmd.tool.core.exception.ArgumentValidationException;
import ss.cmd.tool.core.model.CommandArgument;
import ss.cmd.tool.core.model.PositionCommandArgument;
import ss.cmd.tool.core.util.ServiceLocator;
import ss.cmd.tool.core.util.Terminal;

/**
 * Application entry point.
 * @author alex
 */
public class Main {
    /** Logger. */
    private final static Logger LOG = System.getLogger(Main.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        CommandProvider commandProvider = getCommandProvider(args);
        Set<CommandArgument> commandArguments = parseArguments(commandProvider, args);
        commandProvider.execute(commandArguments);
    }
    /**
     * Get command provider.
     * @param args command line arguments.
     * @return command provider.
     */
    private static CommandProvider getCommandProvider(String[] args) {
        String commandName = args.length > 0 ? args[0] : "help";
        LOG.log(Logger.Level.DEBUG, "Command name [" + commandName + "]");
        List<CommandProvider> allCommands = ServiceLocator.services(CommandProvider.class);
        List<CommandProvider> commandProviders = allCommands.stream().filter((cp) -> {
            return cp.commandAliases().contains(commandName);
        }).collect(Collectors.toList());
        if (commandProviders.isEmpty()) {
            Terminal.output("Command [" + commandName + "] not found. Please check your command syntax...");
            return allCommands.stream().filter((cp) -> {
                return cp.commandAliases().contains("help");
            }).findFirst().get();
        } else {
            return commandProviders.iterator().next();
        }
    }
    
    private static Set<CommandArgument> parseArguments(CommandProvider commandProvider, String[] args)
            throws ArgumentValidationException {
        String[] commandArgumentsSource = args.length > 0 ? Arrays.copyOfRange(args, 1, args.length) : new String[0];
        Set<CommandArgument> commandArguments = commandProvider.arguments();
        commandArguments.stream().forEach(a -> {
            if (a instanceof PositionCommandArgument) {
                PositionCommandArgument positionArgument = (PositionCommandArgument) a;
                if (positionArgument.getPosition() < commandArgumentsSource.length) {
                    String val = commandArgumentsSource[positionArgument.getPosition()];
                    positionArgument.setValue(val);
                }
            }
            LOG.log(Logger.Level.DEBUG, "argument: " + a);
        });
        for (CommandArgument commandArgument : commandArguments) {
            commandArgument.validation();
        }
        return commandArguments;
    }
}
