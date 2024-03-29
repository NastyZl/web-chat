package org.example.command.action;

import org.example.command.Command;
import org.example.data.MemoryUserRepo;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        @SuppressWarnings("unchecked") final AtomicReference<MemoryUserRepo> memoryUserRepo = (AtomicReference<MemoryUserRepo>) request.getServletContext().getAttribute("memoryUserRepo");

        String login = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");
        System.out.println("login =" + login + " password = " + password);
        Optional<User> user = memoryUserRepo.get().findByLogin(login);
        System.out.println("user");
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            memoryUserRepo.get().findByLogin(login).get().setOnline(true);
            user.get().setOnline(true);
            request.getSession(true).setAttribute("user", user.get());
            System.out.println("    аттрибут user в сессии " + session.getAttribute("user"));
        }
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
