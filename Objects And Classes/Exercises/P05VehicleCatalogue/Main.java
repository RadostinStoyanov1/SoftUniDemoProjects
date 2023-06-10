package P23ObjectsAndClasses_Exercises.P05VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> carsList = new ArrayList<>();
        List<Vehicle> trucksList = new ArrayList<>();

        int sumHorsePowerCars = 0;
        int sumHorsePowerTrucks = 0;
        int carsCounter = 0;
        int trucksCounter = 0;

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String vehicleType = command.split(" ")[0];
            String model = command.split(" ")[1];
            String color = command.split(" ")[2];
            int hp = Integer.parseInt(command.split(" ")[3]);

            Vehicle currentVehicle = new Vehicle(model, color, hp);

            if (vehicleType.equals("car")) {
                carsList.add(currentVehicle);
                carsCounter++;
                sumHorsePowerCars += hp;
            } else if (vehicleType.equals("truck")) {
                trucksList.add(currentVehicle);
                trucksCounter++;
                sumHorsePowerTrucks += hp;
            }

            command = scanner.nextLine();
        }

        String input = scanner.nextLine();

        while (!input.equals("Close the Catalogue")) {
            boolean isFound = false;
            for (Vehicle vehicle : carsList) {
                if (vehicle.getModel().equals(input)) {
                    isFound = true;
                    System.out.println("Type: Car");
                    System.out.printf("Model: %s%n", vehicle.getModel());
                    System.out.printf("Color: %s%n", vehicle.getColor());
                    System.out.printf("Horsepower: %d%n", vehicle.getHorsePower());
                    break;
                }
            }
            if (!isFound) {
                for (Vehicle truck : trucksList) {
                    if (truck.getModel().equals(input)) {
                        System.out.println("Type: Truck");
                        System.out.printf("Model: %s%n", truck.getModel());
                        System.out.printf("Color: %s%n", truck.getColor());
                        System.out.printf("Horsepower: %d%n", truck.getHorsePower());
                        break;
                    }
                }
            }

            input = scanner.nextLine();
        }

        double averageHPCars = 0;
        double averageHPtrucks = 0;

        if (carsCounter == 0 || trucksCounter == 0) {
            if (carsCounter == 0) {
                sumHorsePowerCars = 0;
                averageHPtrucks = sumHorsePowerTrucks / (trucksCounter * 1.0);
            }
            if (trucksCounter == 0) {
                sumHorsePowerTrucks = 0;
                averageHPCars = sumHorsePowerCars / (carsCounter * 1.0);
            }
        } else {
            averageHPCars = sumHorsePowerCars / (carsCounter * 1.0);
            averageHPtrucks = sumHorsePowerTrucks / (trucksCounter * 1.0);
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHPCars);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageHPtrucks);

    }
}
