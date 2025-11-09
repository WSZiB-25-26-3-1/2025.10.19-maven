package pl.edu.wszib.powtorka.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Car {
    private final String brand;
    private final String model;
    private final String plate;
    private boolean rent;

    public Car(String brand, String model, String plate) {
        this(brand, model, plate, false);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getBrand())
                .append(" ")
                .append(this.getModel())
                .append(" ")
                .append(this.getPlate())
                .append(" ")
                .append(this.isRent() ? "RENTED" : "AVAILABLE")
                .toString();
    }
}
