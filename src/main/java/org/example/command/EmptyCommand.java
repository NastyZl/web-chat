package org.example.command;

import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.PAGE_CHAT;
import static org.example.Resources.PAGE_LOGIN;

public class EmptyCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("-----------------------");
        System.out.println("EMPTY COMMAND");
        System.out.println("-----------------------");
        return new ForwardResult(PAGE_CHAT);
    }
}
