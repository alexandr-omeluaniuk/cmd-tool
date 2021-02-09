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
package ss.cmd.tool.core.model;

/**
 * Command argument.
 * @author alex
 */
public class CommandArgument implements Comparable<CommandArgument> {
    /** Name. */
    private String name;
    /** Argument position. Starts with 0. */
    private Integer position;
    /** Validation: Is required. */
    private boolean required;
    /** Validation: Is value is required. */
    private boolean valueRequired;
    /** Value. */
    private String value;
    /**
     * Constructor.
     * @param name argument name.
     */
    public CommandArgument(String name) {
        this.name = name;
        this.required = false;
        this.valueRequired = true;
    }
    /**
     * Constructor.
     * @param position argument position. 
     */
    public CommandArgument(Integer position) {
        this.position = position;
        this.required = false;
        this.valueRequired = true;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }
    /**
     * @param required the required to set
     */
    public CommandArgument setRequired(boolean required) {
        this.required = required;
        return this;
    }
    /**
     * @return the valueRequired
     */
    public boolean isValueRequired() {
        return valueRequired;
    }
    /**
     * @param valueRequired the valueRequired to set
     */
    public CommandArgument setValueRequired(boolean valueRequired) {
        this.valueRequired = valueRequired;
        return this;
    }
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public CommandArgument setValue(String value) {
        this.value = value;
        return this;
    }
    /**
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }
    /**
     * @param position the position to set
     */
    public CommandArgument setPosition(Integer position) {
        this.position = position;
        return this;
    }
    @Override
    public int compareTo(CommandArgument o) {
        return this.getName().compareTo(o.getName());
    }
}
