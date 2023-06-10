package P23ObjectsAndClasses_More_Exercises.P02RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];
            int engineSpeed = Integer.parseInt(input.split("\\s+")[1]);
            int enginePower = Integer.parseInt(input.split("\\s+")[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(input.split("\\s+")[3]);
            String cargoType = input.split("\\s+")[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            double tyre1Pressure = Double.parseDouble(input.split("\\s+")[5]);
            int tyre1Age = Integer.parseInt(input.split("\\s+")[6]);
            double tyre2Pressure = Double.parseDouble(input.split("\\s+")[7]);
            int tyre2Age = Integer.parseInt(input.split("\\s+")[8]);
            double tyre3Pressure = Double.parseDouble(input.split("\\s+")[9]);
            int tyre3Age = Integer.parseInt(input.split("\\s+")[10]);
            double tyre4Pressure = Double.parseDouble(input.split("\\s+")[11]);
            int tyre4Age = Integer.parseInt(input.split("\\s+")[12]);
            Tyre tyre = new Tyre(tyre1Pressure, tyre1Age, tyre2Pressure, tyre2Age, tyre3Pressure, tyre3Age, tyre4Pressure, tyre4Age);
            Car car = new Car(model, engine, cargo, tyre);
            carList.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            for (Car car : carList) {
                if (car.getCargo().getCargoType().equals("fragile")) {
                    if (car.getTyre().getTyre1Pressure() < 1 || car.getTyre().getTyre2Pressure() < 1 || car.getTyre().getTyre3Pressure() < 1 || car.getTyre().getTyre4Pressure() < 1) {
                        System.out.println(car.getModel());
                    }
                }
            }
        } else if (command.equals("flamable")) {
            for (Car car : carList) {
                if (car.getCargo().getCargoType().equals("flamable")) {
                    if (car.getEngine().getEnginePower() > 250) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }

    }
}
