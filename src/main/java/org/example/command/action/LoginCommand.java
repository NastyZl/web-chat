package org.example.command.action;

import org.example.command.Command;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        // Ваша реализация выполнения входа в Чат

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
