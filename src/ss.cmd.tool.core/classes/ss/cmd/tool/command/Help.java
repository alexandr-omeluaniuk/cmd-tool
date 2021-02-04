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
package ss.cmd.tool.command;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import ss.cmd.tool.api.CommandProvider;
import ss.cmd.tool.model.CommandArgument;

/**
 * Help command.
 * @author alex
 */
public class Help implements CommandProvider {

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
        return new HashSet<>();
    }

    @Override
    public void execute(Map<String, String> args) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
