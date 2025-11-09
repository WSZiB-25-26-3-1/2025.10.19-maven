package pl.edu.wszib.powtorka.authentication;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.database.CarRepository;
import pl.edu.wszib.powtorka.database.ICarRepository;
import pl.edu.wszib.powtorka.database.UserRepository;
import pl.edu.wszib.powtorka.model.User;

@Component
public class Authenticator {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ICarRepository carRepository;

    public boolean authenticate(String username, String password) {
        User user = this.userRepository.findUserByLogin(username);
        if(user != null && user.getPassword().equals(DigestUtils.md5Hex(password))) {
            return true;
        }
        return false;

    }
}
