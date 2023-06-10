package P23ObjectsAndClasses_More_Exercises.P03CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> enginesList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            String engineModel = input.split("\\s+")[0];
            int power = Integer.parseInt(input.split("\\s+")[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            Engine engine = new Engine(engineModel, power, displacement, efficiency);
            if (inputArr.length == 3) {
                if (Character.isDigit(inputArr[2].charAt(0))) {
                    engine.setDisplacement(inputArr[2]);
                } else if (Character.isLetter(inputArr[2].charAt(0))) {
                    engine.setEfficiency(inputArr[2]);
                }
            } else if (inputArr.length == 4) {
                engine.setDisplacement(inputArr[2]);
                engine.setEfficiency(inputArr[3]);
            }
            enginesList.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            String carModel = inputArr[0];
            String engineName = inputArr[1];
            Engine currentEngine = null;
            for (int j = 0; j < enginesList.size(); j++) {
                if (enginesList.get(j).getModel().equals(engineName)) {
                    currentEngine = enginesList.get(j);
                    break;
                }
            }
            String weight = "n/a";
            String efficiency = "n/a";
            Car car = new Car(carModel, currentEngine, weight, efficiency);
            if (inputArr.length == 3) {
                if (Character.isDigit(inputArr[2].charAt(0))) {
                    car.setWeight(inputArr[2]);
                } else if (Character.isLetter(inputArr[2].charAt(0))) {
                    car.setColor(inputArr[2]);
                }
            } else if (inputArr.length == 4) {
                car.setWeight(inputArr[2]);
                car.setColor(inputArr[3]);
            }
            carList.add(car);
        }
        for (Car car : carList) {
            System.out.println(car);
        }

    }
}
