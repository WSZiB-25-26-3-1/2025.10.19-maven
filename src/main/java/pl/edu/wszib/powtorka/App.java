package pl.edu.wszib.powtorka;

import pl.edu.wszib.powtorka.authentication.Authenticator;
import pl.edu.wszib.powtorka.database.CarRepository;
import pl.edu.wszib.powtorka.database.ICarRepository;
import pl.edu.wszib.powtorka.exceptions.CanNotRentCarException;
import pl.edu.wszib.powtorka.gui.GUI;
import pl.edu.wszib.powtorka.model.User;

public class App {
    public static void main(String[] args) {
        ICarRepository carRepository = CarRepository.getInstance();
        GUI gui = new GUI();
        Authenticator authenticator = new Authenticator();

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
