package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.exception.StackCalcException;

import java.util.Map;
import java.util.Stack;

public class Sqrt extends Command {

    public Sqrt() {
    }

    public Sqrt(Stack<Double> stack, Map<String,Double> definitions) {
        super(stack, definitions);
    }


    public void execute() throws StackCalcException {
        if (!stack.isEmpty()) {
            Double d1 = stack.pop();
            Double result = Math.sqrt(d1);
            stack.push(result);
        } else throw new StackCalcException("Not enough arguments");
    }
}
