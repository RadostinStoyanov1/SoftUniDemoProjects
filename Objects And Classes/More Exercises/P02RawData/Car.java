package P23ObjectsAndClasses_More_Exercises.P02RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyre;

    public Car(String model, Engine engine, Cargo cargo, Tyre tyre) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyre = tyre;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}
