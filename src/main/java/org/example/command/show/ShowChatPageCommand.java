package org.example.command.show;

import org.example.command.Command;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.Resources.PAGE_CHAT;

public class ShowChatPageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {

        // Ваша реализация наполнения данными главной страницы чата

        return new ForwardResult(PAGE_CHAT);
    }
}
