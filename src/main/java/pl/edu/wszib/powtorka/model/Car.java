package pl.edu.wszib.powtorka.model;

public class Car {
    private final String brand;
    private final String model;
    private final String plate;
    private boolean rent;

    public Car(String brand, String model, String plate, boolean rent) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.rent = rent;
    }

    public Car(String brand, String model, String plate) {
        this(brand, model, plate, false);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
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
