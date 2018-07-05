package com.jcourse.vlsnk.command;


import com.jcourse.vlsnk.exception.CalculatorException;

interface Command {

    void execute() throws CalculatorException;

}
