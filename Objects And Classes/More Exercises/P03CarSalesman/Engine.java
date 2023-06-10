package P23ObjectsAndClasses_More_Exercises.P03CarSalesman;

public class Engine {
    private String engineModel;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, int power, String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return engineModel;
    }

    public void setModel(String model) {
        this.engineModel = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String output = "";
        output += "  " + engineModel + ":\n";
        output += "    Power: " + power + "\n";
        output += "    Displacement: " + displacement + "\n";
        output += "    Efficiency: " + efficiency + "\n";
        return output;
    }
}
