package com.jcourse.vlsnk.command;


import com.jcourse.vlsnk.exception.CalculatorException;

public interface Command {

    void execute() throws CalculatorException;

}
