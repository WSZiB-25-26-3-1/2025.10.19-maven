package pl.edu.wszib.powtorka.database;

import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User("admin", "21232f297a57a5a743894a0e4a801fc3"));
        this.users.add(new User("user", "ee11cbb19052e40b07aac0ca060c23ee"));
    }

    @Override
    public User findUserByLogin(String login) {
        for(User u : this.users) {
            if(u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
