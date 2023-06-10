package P23ObjectsAndClasses_Exercises.P05VehicleCatalogue;

public class Vehicle {
    private String model;
    private String color;
    private int horsePower;

    public Vehicle(String model, String color, int horsePower) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

}
