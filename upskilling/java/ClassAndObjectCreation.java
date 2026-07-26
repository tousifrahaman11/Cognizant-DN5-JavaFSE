public class ClassAndObjectCreation {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2024);
        Car car2 = new Car("Honda", "Civic", 2025);
        car1.displayDetails();
        car2.displayDetails();
    }
}

class Car {
    private final String make;
    private final String model;
    private final int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayDetails() {
        System.out.println("Car: " + make + " " + model + " (" + year + ")");
    }
}