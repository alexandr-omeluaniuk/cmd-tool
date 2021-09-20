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

import ss.cmd.tool.core.exception.ArgumentValidationException;

/**
 * Command argument from certain position.
 * @author alex
 */
public class PositionCommandArgument extends CommandArgument implements Comparable<PositionCommandArgument> {
    /** Position. */
    private Integer position;
    /** Argument value. */
    private String value;
    /**
     * Constructor.
     * @param position argument position. 
     */
    public PositionCommandArgument(Integer position) {
        this.position = position;
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
    public void setPosition(Integer position) {
        this.position = position;
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
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void validation() throws ArgumentValidationException {
        if (isRequired() && getValue() == null) {
            throw new ArgumentValidationException(this, "argument in position [" + getPosition() + "] is required");
        }
    }
    @Override
    public int compareTo(PositionCommandArgument o) {
        return this.getPosition() > o.getPosition() ? -1 : 1;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PositionCommandArgument [").append(getPosition()).append("] [").append(getValue()).append("]");
        return sb.toString();
    }
}
