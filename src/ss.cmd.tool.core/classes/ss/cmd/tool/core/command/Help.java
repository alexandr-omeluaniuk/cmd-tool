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
package ss.cmd.tool.core.command;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import ss.cmd.tool.core.api.CommandProvider;
import ss.cmd.tool.core.model.CommandArgument;
import ss.cmd.tool.core.model.PositionCommandArgument;
import ss.cmd.tool.core.util.Terminal;

/**
 * Help command.
 * @author alex
 */
public class Help implements CommandProvider {
    /** Logger. */
    private final static System.Logger LOG = System.getLogger(Help.class.getName());
    /** Position command. */
    private static final int POS_COMMAND = 0;
    @Override
    public Set<String> commandAliases() {
        Set<String> aliases = new HashSet<>();
        aliases.add("help");
        aliases.add("-help");
        aliases.add("--h");
        return aliases;
    }
    @Override
    public Set<CommandArgument> arguments() {
        Set<CommandArgument> args = new TreeSet<>();
        args.add(new PositionCommandArgument(POS_COMMAND));
        return args;
    }
    @Override
    public void execute(Set<CommandArgument> args) throws Exception {
        PositionCommandArgument command = getPositionArgument(POS_COMMAND, args);
        if (command != null && command.getValue() != null) {
            LOG.log(System.Logger.Level.DEBUG, "help for command [" + command.getValue() + "]");
            Terminal.output(outputCommandHelp(command.getValue()));
        } else {
            Terminal.output(outputFullHelp());
        }
    }
    /**
     * Output help for a command.
     * @param commandName a command name.
     * @return help text for a command.
     */
    private String outputCommandHelp(String commandName) {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();
    }
    /**
     * Output full help text.
     * @return help text for all commands.
     */
    private String outputFullHelp() {
        StringBuilder sb = new StringBuilder();
        
        return sb.toString();
    };
}
