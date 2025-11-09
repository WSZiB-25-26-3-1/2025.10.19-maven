package pl.edu.wszib.powtorka.database;

import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.exceptions.CanNotRentCarException;
import pl.edu.wszib.powtorka.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component("y")
public class CarRepository2 implements ICarRepository {
    private final List<Car> cars = new ArrayList<>();

    public CarRepository2() {
        this.cars.add(new Car("Toyota2", "Corolla", "KR11"));
        this.cars.add(new Car("Kia2", "Ceed", "KR22"));
        this.cars.add(new Car("Fiat2", "Panda", "KR33"));
        this.cars.add(new Car("BMW2", "3", "KR44"));
        this.cars.add(new Car("Opel2", "Astra", "KR55"));
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
