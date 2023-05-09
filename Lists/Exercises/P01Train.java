package P18List_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfPassengersPerWagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int wagonsCapacity =  Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.startsWith("Add")) {
                listOfPassengersPerWagons = addWagon(listOfPassengersPerWagons, Integer.parseInt(command.split(" ")[1]));
            } else {
                listOfPassengersPerWagons = addPassengers(listOfPassengersPerWagons, Integer.parseInt(command), wagonsCapacity);
            }

            command = scanner.nextLine();
        }

        for (Integer wagon : listOfPassengersPerWagons) {
            System.out.print(wagon + " ");
        }
        System.out.println();

    }

    public static List<Integer> addPassengers (List<Integer> train, int passengersToSet, int wagonCapacity) {
        for (int i = 0; i < train.size(); i++) {
            if (train.get(i) + passengersToSet <= wagonCapacity) {
                train.set(i, train.get(i) + passengersToSet);
                break;
            }
        }
        return train;
    }

    public static List<Integer> addWagon (List<Integer> train, int passengersToAdd) {
        train.add(passengersToAdd);
        return train;
    }

}
