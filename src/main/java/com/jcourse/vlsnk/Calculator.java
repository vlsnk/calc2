package com.jcourse.vlsnk;

import com.jcourse.vlsnk.command.*;
import com.jcourse.vlsnk.exception.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

    private static final String DEFINE = "DEFINE";
    private static final String DIVISION = "/";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String POP = "POP";
    private static final String PUSH = "PUSH";
    private static final String PRINT = "PRINT";
    private static final String SQRT = "SQRT";
    private static final String SUM = "+";

    protected Stack<Double> stack = new Stack<Double>();
    protected Map<String, Double> definitions = new HashMap<String, Double>();
    protected String[] args;

    public void addCommand(String s) throws CalculatorException {

        args = s.split(" ");
        if (args.length==0) return;
        Command c = null;

        String type = args[0];
        switch (type) {
            case DEFINE: {
                c = new Define(stack,definitions);
                ((Define) c).addArgument(args);
                break;
            }
            case DIVISION: {
                c = new Division(this.stack, definitions);
                break;
            }
            case MINUS: {
                c = new Minus(stack, definitions);
                break;
            }
            case MULTIPLY: {
                c = new Multiply(stack, definitions);
                break;
            }
            case POP: {
                c = new Pop(stack, definitions);
                break;
            }
            case PRINT: {
                c = new Print(stack, definitions);

                break;
            }
            case PUSH: {
                c = new Push(stack, definitions);
                ((Push) c).setPush(args[1]);
                break;
            }
            case SQRT: {
                c = new Sqrt(stack, definitions);
                break;
            }
            case SUM: {
                c = new Sum(stack, definitions);
                break;
            }
        }
        if (c != null) {
            c.execute();
        } else throw new WrongCommand("Wrong command");
    }

    public void addFile(String s) throws CalculatorException {

        InputStream stream = Calculator.class.getClassLoader().getResourceAsStream(s);
        Scanner in = new Scanner(stream);
        while (in.hasNextLine()) {
            addCommand(in.nextLine());
        }
    }

    void clear(){
        stack.clear();
        definitions.clear();
    }
}
