package pl.edu.wszib.powtorka.database;

import pl.edu.wszib.powtorka.exceptions.CanNotRentCarException;
import pl.edu.wszib.powtorka.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {
    private final List<Car> cars = new ArrayList<>();

    public CarRepository() {
        this.cars.add(new Car("Toyota", "Corolla", "KR11"));
        this.cars.add(new Car("Kia", "Ceed", "KR22"));
        this.cars.add(new Car("Fiat", "Panda", "KR33"));
        this.cars.add(new Car("BMW", "3", "KR44"));
        this.cars.add(new Car("Opel", "Astra", "KR55"));
    }

    @Override
    public void rentCar(String plate) {
        for(Car c : this.cars) {
            if(c.getPlate().equals(plate) && !c.isRent()) {
                c.setRent(true);
                return;
            }
        }

        throw new CanNotRentCarException();
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
