package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.exception.StackCalcException;

import java.util.Map;
import java.util.Stack;

public class Pop extends Command {

    public Pop() {
    }

    public Pop(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void execute() throws StackCalcException {
        if (!stack.empty()) {
            System.out.println(super.stack.pop());
        } else throw new StackCalcException("Not enough arguments");
    }
}
