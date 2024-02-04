package org.example.command.show;

import org.example.command.Command;
import org.example.data.MemoryUserRepo;
import org.example.data.Message;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import static org.example.Resources.PAGE_ADMIN;

public class ShowAdminPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @SuppressWarnings("unchecked") final AtomicReference<MemoryUserRepo> memoryUserRepo = (AtomicReference<MemoryUserRepo>) request.getServletContext().getAttribute("memoryUserRepo");
        List<User> usersAll = memoryUserRepo.get().findAllUsers();
        List<User> usersClient = usersAll.stream()
                .filter(user -> user.getUserType().equals(UserType.CLIENT))
                .collect(Collectors.toList());
        request.setAttribute("users", usersClient);
        return new ForwardResult(PAGE_ADMIN);
    }
}
