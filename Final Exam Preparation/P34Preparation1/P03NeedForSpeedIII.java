package P34ExamPreparation;

import java.util.*;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();

        for (int i = 1; i <= numCars; i++) {
            String[] details = scanner.nextLine().split("\\|");
            String carModel = details[0];
            int mileage = Integer.parseInt(details[1]);
            int fuel = Integer.parseInt(details[2]);

            carsMap.putIfAbsent(carModel, new ArrayList<>());
            carsMap.get(carModel).add(mileage);
            carsMap.get(carModel).add(fuel);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String car = command.split(" : ")[1];
            int currentMileage = carsMap.get(car).get(0);
            int currentFuel = carsMap.get(car).get(1);

            if (command.contains("Drive")) {
                int drivenDistance = Integer.parseInt(command.split(" : ")[2]);
                int consumedFuel = Integer.parseInt(command.split(" : ")[3]);
                if (carsMap.get(car).get(1) < consumedFuel) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, drivenDistance, consumedFuel);
                    carsMap.get(car).set(0, currentMileage + drivenDistance);
                    carsMap.get(car).set(1, currentFuel - consumedFuel);
                }

                if (carsMap.get(car).get(0) > 100000) {
                    System.out.printf("Time to sell the %s!%n", car);
                    carsMap.remove(car);
                }

            } else if (command.contains("Refuel")) {
                int fuelToRefill = Integer.parseInt(command.split(" : ")[2]);
                if (fuelToRefill + currentFuel <= 75) {
                    carsMap.get(car).set(1, fuelToRefill + currentFuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuelToRefill);
                } else {
                    int actualRefilledFuel = 75 - currentFuel;
                    carsMap.get(car).set(1, 75);
                    System.out.printf("%s refueled with %d liters%n", car, actualRefilledFuel);
                }
            } else if (command.contains("Revert")) {
                int revertedMileage = Integer.parseInt(command.split(" : ")[2]);
                if (currentMileage - revertedMileage < 10000) {
                    carsMap.get(car).set(0, 10000);
                } else {
                    carsMap.get(car).set(0, currentMileage - revertedMileage);
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, revertedMileage);
                }
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : carsMap.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
