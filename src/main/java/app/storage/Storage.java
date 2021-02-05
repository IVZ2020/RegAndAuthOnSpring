package app.storage;

import app.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Storage {

    List<User> userList = new ArrayList<>();

    public boolean addUser (String login, String password) {
        return userList.add(new User(login, password));
    }

    public boolean isLoginExist(String login) {
        for (User user : userList
        ) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordCorrect (String login, String password) {
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
