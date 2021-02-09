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
package ss.cmd.tool.core.api;

import java.util.Set;
import ss.cmd.tool.core.model.CommandArgument;
import ss.cmd.tool.core.model.PositionCommandArgument;

/**
 * Terminal command provider.
 * @author alex
 */
public interface CommandProvider {
    /**
     * Command aliases.
     * @return set of command aliases, for example 'help', '-help', '--h'.
     */
    Set<String> commandAliases();
    /**
     * Command arguments list.
     * @return command arguments.
     */
    Set<CommandArgument> arguments();
    /**
     * Execute command.
     * @param args command arguments.
     * @throws Exception error.
     */
    void execute(Set<CommandArgument> args) throws Exception;
    /**
     * Arguments separator.
     * @return arguments separator string.
     */
    default String argumentsSeparator() {
        return " ";
    }
    /**
     * Name-Value separator.
     * @return value separator string.
     */
    default String valueSeparator() {
        return "=";
    }
    /**
     * Get argument by it position.
     * @param position argument position.
     * @return argument or null.
     */
    default PositionCommandArgument getPositionArgument(final Integer position) {
        return (PositionCommandArgument) this.arguments().stream().filter(a -> {
            return a instanceof PositionCommandArgument;
        }).filter(a -> {
            return position.equals(((PositionCommandArgument) a).getPosition());
        }).findFirst().get();
    }
}
