package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryUserRepo {
    private final static List<User> USERS = new ArrayList<>();

//    static {
//        USERS.add(new User("admin", "1", "Олег", UserType.ADMIN));
//        USERS.add(new User("client", "1", "Настя", UserType.CLIENT));
//    }

    public List<User> findAllUsers() {
        return USERS;
    }

    public Optional<User> findByLogin(String login) {
        return USERS.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }
    public boolean addUser(User user) {

        for (User u: USERS) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return USERS.add(user);
    }

    public boolean userExist(String login, String password) {
        return  USERS.stream()
                .anyMatch(u -> u.getLogin().equals(login) && u.getPassword().equals(password));
    }
}
