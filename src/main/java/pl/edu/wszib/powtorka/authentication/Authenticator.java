package pl.edu.wszib.powtorka.authentication;

import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.database.CarRepository;
import pl.edu.wszib.powtorka.database.ICarRepository;
import pl.edu.wszib.powtorka.database.IUserRepository;
import pl.edu.wszib.powtorka.database.UserRepository;
import pl.edu.wszib.powtorka.model.User;

@Component
@RequiredArgsConstructor
public class Authenticator implements IAuthenticator{
    private final IUserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        User user = this.userRepository.findUserByLogin(username);
        if(user != null && user.getPassword().equals(DigestUtils.md5Hex(password))) {
            return true;
        }
        return false;

    }
}
