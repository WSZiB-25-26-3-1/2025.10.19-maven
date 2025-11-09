package pl.edu.wszib.powtorka.database;

import org.springframework.stereotype.Component;
import pl.edu.wszib.powtorka.model.Car;

import java.util.List;

@Component
public class CarRepositoryv2 implements ICarRepository {
    @Override
    public void rentCar(String plate) {

    }

    @Override
    public List<Car> getCars() {
        return List.of();
    }
}
