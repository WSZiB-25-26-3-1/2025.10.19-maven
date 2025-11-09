package pl.edu.wszib.powtorka.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.authentication.Authenticator;
import pl.edu.wszib.powtorka.authentication.IAuthenticator;
import pl.edu.wszib.powtorka.database.ICarRepository;
import pl.edu.wszib.powtorka.exceptions.CanNotRentCarException;
import pl.edu.wszib.powtorka.gui.IGUI;
import pl.edu.wszib.powtorka.model.User;

@Component
@RequiredArgsConstructor
public class Core implements ICore{
    private final ICarRepository carRepository;
    private final IGUI gui;
    private final IAuthenticator authenticator;

    @Override
    public void run() {
        User user = gui.readLoginAndPassword();
        boolean isAuthenticated = authenticator.authenticate(
                user.getLogin(),
                user.getPassword());

        while(isAuthenticated) {
            switch (gui.showMenuAndReadChoose()) {
                case "1":
                    gui.listCars(carRepository.getCars());
                    break;
                case "2":
                    try {
                        carRepository.rentCar(gui.readPlate());
                        gui.showRentSuccessMessage(true);
                    } catch (CanNotRentCarException e) {
                        gui.showRentSuccessMessage(false);
                    }
                    break;
                case "3":
                    return;
                default:
                    gui.showWrongOptionMessage();
                    break;
            }
        }
    }
}
