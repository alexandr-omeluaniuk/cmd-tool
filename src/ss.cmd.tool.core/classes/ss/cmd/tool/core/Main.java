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
import java.util.List;
import ss.cmd.tool.api.CommandProvider;
import ss.cmd.tool.util.ServiceLocator;

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
    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
        } else {
            
        }
    }
    
    private static void parseCommandLineArguments(String[] args) {
        String commandName = args[0];
        LOG.log(Logger.Level.DEBUG, "Command name [" + commandName + "]");
        List<CommandProvider> commandProviders = ServiceLocator.services(CommandProvider.class);
        commandProviders.stream().anyMatch((cp) -> {
            return cp.commandAliases().contains(commandName);
        });
        if (commandProviders.isEmpty()) {
            LOG.log(Logger.Level.ERROR, "Command not found: " + commandName);
        } else {
            
        }
    }
    
    private static void printHelp() {
        List<CommandProvider> commandProviders = ServiceLocator.services(CommandProvider.class);
        commandProviders.stream().anyMatch((cp) -> {
            return cp.commandAliases().contains("help");
        });
        
    }
}
