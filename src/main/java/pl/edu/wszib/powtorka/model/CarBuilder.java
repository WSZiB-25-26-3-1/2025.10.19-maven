package pl.edu.wszib.powtorka.model;

public class CarBuilder {
    private String brand;
    private String model;
    private String plate;
    private boolean rent = false;

    public CarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder plate(String plate) {
        this.plate = plate;
        return this;
    }

    public CarBuilder rent(boolean rent) {
        this.rent = rent;
        return this;
    }

    public Car build() {
        return new Car(brand, model, plate, rent);
    }
}

