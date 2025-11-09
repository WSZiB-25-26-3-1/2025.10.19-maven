package pl.edu.wszib.powtorka.gui;

import pl.edu.wszib.powtorka.model.Car;
import pl.edu.wszib.powtorka.model.User;

import java.util.List;

public interface IGUI {
    String showMenuAndReadChoose();
    String readPlate();
    void listCars(List<Car> cars);
    void showRentSuccessMessage(boolean success);
    void showWrongOptionMessage();
    User readLoginAndPassword();
}
