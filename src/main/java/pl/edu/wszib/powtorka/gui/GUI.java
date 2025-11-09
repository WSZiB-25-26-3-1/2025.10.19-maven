package pl.edu.wszib.powtorka.gui;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.model.Car;
import pl.edu.wszib.powtorka.model.User;

import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class GUI implements IGUI {
    private final Scanner scanner;

    @Override
    public String showMenuAndReadChoose() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Exit");

        return this.scanner.nextLine();
    }

    @Override
    public String readPlate() {
        System.out.println("Plate:");

        return this.scanner.nextLine();
    }

    @Override
    public void listCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void showRentSuccessMessage(boolean success) {
        System.out.println(
                success ?
                        "Car rented successfully." :
                        "Cannot rent the car.");
    }

    @Override
    public void showWrongOptionMessage() {
        System.out.println("Wrong option. Please try again.");
    }

    @Override
    public User readLoginAndPassword() {
        System.out.println("Login: ");
        String login = this.scanner.nextLine();
        System.out.println("Password: ");
        return new User(login, this.scanner.nextLine());
    }
}
