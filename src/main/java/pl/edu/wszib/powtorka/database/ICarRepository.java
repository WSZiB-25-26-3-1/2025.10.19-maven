package pl.edu.wszib.powtorka.database;

import pl.edu.wszib.powtorka.model.Car;

import java.util.List;

public interface ICarRepository {
    void rentCar(String plate);
    List<Car> getCars();
}
