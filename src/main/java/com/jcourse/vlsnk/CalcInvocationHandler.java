package com.jcourse.vlsnk;

import com.jcourse.vlsnk.command.Command;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class CalcInvocationHandler implements InvocationHandler {

    static Logger log = Logger.getLogger(CalcInvocationHandler.class);
    Command command;
    protected Stack<Double> stackBefore = new Stack<Double>();
    protected Map<String, Double> vars = new HashMap<String, Double>();
    static List<LogInfo> logInfoList = new ArrayList<>();

    public CalcInvocationHandler(Command command, Stack<Double> stackBefore, Map<String, Double> vars) {
        this.command = command;
        this.stackBefore = stackBefore;
        this.vars = vars;
        logInfoList.add( new LogInfo(command.getClass().getName(),
                                    (Stack<Double>)stackBefore.clone(),
                                    vars));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info(method.getName() + " | " + command.toString());
        Object res = method.invoke(command, args);
        if (method.getName().equalsIgnoreCase("execute")) {
            saveHistory();
        }
        return res;
    }

    void saveHistory(){
        logInfoList.get(logInfoList.size()-1).setStackAfter((Stack<Double>)stackBefore.clone());
    }

    public static List<LogInfo> getLog(){
        log.info(logInfoList.size());
        return logInfoList;
    }

}
