package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.annotation.*;
import com.jcourse.vlsnk.exception.*;
import java.util.Map;
import java.util.Stack;

public class Define extends Command {

    @InArgument(Arguments.SET_VAR)
    String setVar;

    @InArgument(Arguments.SET_VALUE)
    Double value = null;

    public Define() {
    }

    public Define(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
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
