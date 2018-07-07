package com.jcourse.vlsnk;

import com.jcourse.vlsnk.annotation.Arguments;
import com.jcourse.vlsnk.annotation.InArgument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LogInfo {
    private String command;
    protected Stack<Double> stackBefore = new Stack<Double>();
    protected Map<String, Double> vars = new HashMap<String, Double>();

    public LogInfo(String command, Stack<Double> stackBefore, Map<String, Double> vars) {
        this.command = command;
        this.stackBefore = stackBefore;
        this.vars = vars;
    }

    protected Stack<Double> stackAfter = new Stack<Double>();

    @Override
    public String toString() {
        return "LogInfo{" +
                "command='" + command + '\'' +
                ", stackBefore=" + stackBefore.size() +
                ", vars=" + vars.size() +
                ", stackAfter=" + stackAfter.size() +
                '}';
    }
}
