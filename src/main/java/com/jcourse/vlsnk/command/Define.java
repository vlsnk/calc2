package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.annotation.*;
import com.jcourse.vlsnk.exception.*;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Define implements Command {

    @InArgument(Arguments.STACK)
    protected static Stack<Double> stack = new Stack<Double>();

    @InArgument(Arguments.DEFINITIONS)
    protected static Map<String, Double> vars = new HashMap<String, Double>();

    @InArgument(Arguments.SET_VAR)
    String setVar;

    @InArgument(Arguments.SET_VALUE)
    Double value = null;

    public Define() {
    }

    public Define(Stack<Double> stack, Map<String, Double> definitions) {
        this.stack = stack;
        this.vars = definitions;
    }

    public void addArgument(String[] args) throws CalculatorException {
        if (args.length < 3) throw new WrongCommand("Wrong command");
        this.setVar = args[1];
        try {
            this.value = Double.valueOf(args[2]);
        } catch (NumberFormatException n) {
            throw new WrongArguments("Wrong TYPE for variable " + this.setVar);
        }
    }

    public void execute() {
        vars.put(setVar, value);
    }


}
