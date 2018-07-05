package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.annotation.InArgument;
import com.jcourse.vlsnk.exception.StackCalcException;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static com.jcourse.vlsnk.annotation.Arguments.DEFINITIONS;
import static com.jcourse.vlsnk.annotation.Arguments.STACK;

public class Sqrt implements Command {

    @InArgument(STACK)
    protected static Stack<Double> stack = new Stack<Double>();

    @InArgument(DEFINITIONS)
    protected static Map<String, Double> vars = new HashMap<String, Double>();

    public Sqrt() {
    }

    public Sqrt(Stack<Double> stack, Map<String,Double> definitions) {
        this.stack = stack;
        this.vars = definitions;
    }


    public void execute() throws StackCalcException {
        if (!stack.isEmpty()) {
            Double d1 = stack.pop();
            Double result = Math.sqrt(d1);
            stack.push(result);
        } else throw new StackCalcException("Not enough arguments");
    }
}
