package com.jcourse.vlsnk;

import com.jcourse.vlsnk.annotation.Arguments;
import com.jcourse.vlsnk.annotation.InArgument;
import com.jcourse.vlsnk.command.*;
import com.jcourse.vlsnk.exception.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class Calculator {

    protected Stack<Double> stack = new Stack<Double>();
    protected Map<String, Double> definitions = new HashMap<String, Double>();
    protected String[] args;

    Properties p = new Properties();

    public void calculate(String s) throws CalculatorException {
        Command c = getCommand(s);
        if (c != null) {
            c.execute();
        } else throw new WrongCommand("Wrong command");
    }

    public void addFile(String s) throws CalculatorException {

        InputStream stream = Calculator.class.getClassLoader().getResourceAsStream(s);
        Scanner in = new Scanner(stream);
        while (in.hasNextLine()) {
            calculate(in.nextLine());
        }
    }

    void clear(){
        stack.clear();
        definitions.clear();
    }

    public Command getCommand(String s) throws WrongArguments {
        args = s.split(" ");
        if (args.length==0) return null;
        InputStream stream = null;
        try {

            stream = Calculator.class.getClassLoader().getResourceAsStream("command.properties");
            p.load(stream);
            Class<?> commandClass = Class.forName(p.get(args[0]).toString());
            /* добавить в команды конструктор по-умолчанию.
            Можно commandClass достать конструкторы и вызвать доступный конструктор
            */
            Object command = commandClass.newInstance();

            Field[] fields= commandClass.getDeclaredFields();

            for (Field f : fields) {
                f.setAccessible(true);
                Annotation a = f.getAnnotation(InArgument.class);
                switch (((InArgument) a).value() ){
                    case STACK: {
                        f.set(command, this.stack);
                        break;
                    }
                    case DEFINITIONS:{
                        f.set(command, this.definitions);
                        break;
                    }
                    case SET_VAR:{
                        f.set(command, args[1]);
                        break;
                    }
                    case SET_VALUE:{
                        try {
                            Double value = Double.valueOf(args[2]);
                            f.set(command, value);
                        } catch (NumberFormatException n) {
                            throw new WrongArguments("Wrong TYPE for variable " + args[1]);
                        }
                        break;
                    }
                    case FIND_VALUE:{
                        f.set(command, args[1]);
                        break;
                    }
                }

            }

            stream.close();
            return (Command) command;
        } catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
