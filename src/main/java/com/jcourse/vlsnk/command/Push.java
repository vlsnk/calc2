package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.annotation.*;
import com.jcourse.vlsnk.exception.NoDefinitionExcetpion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static com.jcourse.vlsnk.annotation.Arguments.DEFINITIONS;
import static com.jcourse.vlsnk.annotation.Arguments.STACK;

public class Push implements Command {

    @InArgument(STACK)
    protected static Stack<Double> stack = new Stack<Double>();

    @InArgument(DEFINITIONS)
    protected static Map<String, Double> vars = new HashMap<String, Double>();

    @InArgument(Arguments.FIND_VALUE)
    String var;

    public Push() {
    }

    public Push(Stack<Double> stack, Map<String, Double> definitions) {
        this.stack = stack;
        this.vars = definitions;
    }

    public void setPush(String s) {
        this.var = s;
    }

    public void execute() throws NoDefinitionExcetpion {
        Double d = null;
        if (vars.containsKey(var)) {
            d = vars.get(var);
        } else {
            d = Double.valueOf(var);
        }
        if (d == null) {
            throw  new NoDefinitionExcetpion("No such variable in DEFINITIONS " + this.var);
        }
        stack.push(d);
    }
}
