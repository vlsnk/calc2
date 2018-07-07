package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.annotation.InArgument;
import com.jcourse.vlsnk.annotation.StackSize;
import com.jcourse.vlsnk.exception.StackCalcException;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static com.jcourse.vlsnk.annotation.Arguments.DEFINITIONS;
import static com.jcourse.vlsnk.annotation.Arguments.STACK;

public class Division implements Command {

    @InArgument(STACK)
    protected static Stack<Double> stack = new Stack<Double>();

    @InArgument(DEFINITIONS)
    protected static Map<String, Double> vars = new HashMap<String, Double>();

    public Division() {
    }

    public Division(Stack<Double> stack, Map<String, Double> definitions) {
        this.stack = stack;
        this.vars = definitions;
    }

    public void execute() throws StackCalcException {
        if (hasTwoNumber()) {
            Double d1 = stack.pop();
            Double d2 = stack.pop();
            Double result = d1 / d2;
            stack.push(result);
        } else throw new StackCalcException("Not enough arguments");
    }

    protected boolean hasTwoNumber() {
        return stack.size() > 1 ? true : false;
    }
}
