package pl.edu.wszib.powtorka.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.authentication.Authenticator;
import pl.edu.wszib.powtorka.database.CarRepository;
import pl.edu.wszib.powtorka.database.ICarRepository;
import pl.edu.wszib.powtorka.exceptions.CanNotRentCarException;
import pl.edu.wszib.powtorka.gui.GUI;
import pl.edu.wszib.powtorka.model.User;

@Component
public class Core {
    @Autowired
    ICarRepository carRepository;
    @Autowired
    GUI gui;
    @Autowired
    Authenticator authenticator;

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
