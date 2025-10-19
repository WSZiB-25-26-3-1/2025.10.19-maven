package pl.edu.wszib.powtorka.database;

import pl.edu.wszib.powtorka.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User("admin", "21232f297a57a5a743894a0e4a801fc3"));
        this.users.add(new User("user", "ee11cbb19052e40b07aac0ca060c23ee"));
    }

    public User findUserByLogin(String login) {
        for(User u : this.users) {
            if(u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
