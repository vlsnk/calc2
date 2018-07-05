package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.annotation.*;
import com.jcourse.vlsnk.exception.NoDefinitionExcetpion;

import java.util.Map;
import java.util.Stack;

public class Push extends Command {

    @InArgument(Arguments.FIND_VALUE)
    String var;

    public Push() {
    }

    public Push(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void setPush(String s) {
        this.var = s;
    }

    public void execute() throws NoDefinitionExcetpion {
        Double d = null;
        if (vars.containsKey(var)) {
            d = super.vars.get(var);
        } else {
            d = Double.valueOf(var);
        }
        if (d == null) {
            throw  new NoDefinitionExcetpion("No such variable in DEFINITIONS " + this.var);
        }
        stack.push(d);
    }
}
