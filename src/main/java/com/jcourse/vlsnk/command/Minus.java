package com.jcourse.vlsnk.command;

import java.util.Map;
import java.util.Stack;

public class Minus extends Command {

    public Minus() {
    }

    public Minus(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void execute() {
        if (hasTwoNumber()) {
            Double d1 = stack.pop();
            Double d2 = stack.pop();
            Double result = d1 - d2;
            stack.push(result);
        }
    }
}
