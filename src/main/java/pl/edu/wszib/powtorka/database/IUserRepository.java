package pl.edu.wszib.powtorka.database;

import pl.edu.wszib.powtorka.model.User;

import java.util.List;

public interface IUserRepository {
    User findUserByLogin(String login);
    List<User> getUsers();
}
