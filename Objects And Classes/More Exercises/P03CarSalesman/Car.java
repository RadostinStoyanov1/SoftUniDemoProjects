package P23ObjectsAndClasses_More_Exercises.P03CarSalesman;

public class Car {
    private String carModel;
    private Engine engineModel;
    private String weight;
    private String color;

    public Car(String carModel, Engine engineModel, String weight, String color) {
        this.carModel = carModel;
        this.engineModel = engineModel;
        this.weight = weight;
        this.color = color;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Engine getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(Engine engineModel) {
        this.engineModel = engineModel;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String output = "";
        output += carModel + ":\n";
        output += engineModel;
        output += "  Weight: " + weight + "\n";
        output += "  Color: " + color;
        return  output;
    }
}
