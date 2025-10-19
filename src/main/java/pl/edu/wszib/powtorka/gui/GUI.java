package pl.edu.wszib.powtorka.gui;

import pl.edu.wszib.powtorka.model.Car;
import pl.edu.wszib.powtorka.model.User;

import java.util.List;
import java.util.Scanner;

public class GUI {
    Scanner scanner = new Scanner(System.in);

    public String showMenuAndReadChoose() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Exit");

        return this.scanner.nextLine();
    }

    public String readPlate() {
        System.out.println("Plate:");

        return this.scanner.nextLine();
    }

    public void listCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void showRentSuccessMessage(boolean success) {
        System.out.println(
                success ?
                        "Car rented successfully." :
                        "Cannot rent the car.");
    }

    public void showWrongOptionMessage() {
        System.out.println("Wrong option. Please try again.");
    }

    public User readLoginAndPassword() {
        System.out.println("Login: ");
        String login = this.scanner.nextLine();
        System.out.println("Password: ");
        return new User(login, this.scanner.nextLine());
    }
}
