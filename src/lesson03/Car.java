package lesson03;

public class Car {
    private String country;
    private String model;
    private int yearOfManufacture;

    public Car(String country, String model, int yearOfManufacture) {
        this.country = country;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void printCarInfo() {
        System.out.printf("Country - %s, model - %s, year of manufacture - %d", country, model, yearOfManufacture);
    }
}
