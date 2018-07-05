package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.annotation.InArgument;
import com.jcourse.vlsnk.exception.NoDefinitionExcetpion;
import com.jcourse.vlsnk.exception.StackCalcException;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static com.jcourse.vlsnk.annotation.Arguments.DEFINITIONS;
import static com.jcourse.vlsnk.annotation.Arguments.STACK;

public abstract class Command {

    @InArgument(STACK)
    protected static Stack<Double> stack = new Stack<Double>();

    @InArgument(DEFINITIONS)
    protected static Map<String, Double> vars = new HashMap<String, Double>();

    public Command() {
    }

    public Command(Stack<Double> stack, Map<String, Double> definitions) {
        this.stack = stack;
        this.vars = definitions;
    }

    public abstract void execute() throws StackCalcException, NoDefinitionExcetpion;

    protected boolean hasTwoNumber() {
        return stack.size() > 1 ? true : false;
    }
}
