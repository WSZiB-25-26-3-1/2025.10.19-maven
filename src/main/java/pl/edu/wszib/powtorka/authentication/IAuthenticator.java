package pl.edu.wszib.powtorka.authentication;

public interface IAuthenticator {
    boolean authenticate(String username, String password);
}
