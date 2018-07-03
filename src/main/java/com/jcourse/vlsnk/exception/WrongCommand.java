package com.jcourse.vlsnk.exception;

public class WrongCommand extends CalculatorException {

    public WrongCommand() {
    }

    public WrongCommand(String message) {
        super(message);
    }
}
