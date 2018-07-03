package com.jcourse.vlsnk.command;

import com.jcourse.vlsnk.exception.CalculatorException;
import com.jcourse.vlsnk.exception.WrongArguments;
import com.jcourse.vlsnk.exception.WrongCommand;

import java.util.Map;
import java.util.Stack;

public class Define extends Command {
    String var;
    Double value = null;

    public Define() {
    }

    public Define(Stack<Double> stack, Map<String, Double> definitions) {
        super(stack, definitions);
    }

    public void addArgument(String[] args) throws CalculatorException {
        if (args.length < 3) throw new WrongCommand("Wrong command");
        this.var = args[1];
        try {
            this.value = Double.valueOf(args[2]);
        } catch (NumberFormatException n) {
            throw new WrongArguments("Wrong TYPE for variable " + this.var);
        }
    }

    public void execute() {
        vars.put(var, value);
    }


}
