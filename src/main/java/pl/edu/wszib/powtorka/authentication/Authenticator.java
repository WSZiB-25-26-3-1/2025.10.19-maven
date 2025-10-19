package pl.edu.wszib.powtorka.authentication;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.wszib.powtorka.database.UserRepository;
import pl.edu.wszib.powtorka.model.User;

public class Authenticator {
    private final UserRepository userRepository = new UserRepository();

    public boolean authenticate(String username, String password) {
        User user = this.userRepository.findUserByLogin(username);
        if(user != null && user.getPassword().equals(DigestUtils.md5Hex(password))) {
            return true;
        }
        return false;

    }
}
