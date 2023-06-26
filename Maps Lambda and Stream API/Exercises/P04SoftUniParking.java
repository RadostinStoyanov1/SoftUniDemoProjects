package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> carsMap = new LinkedHashMap<>();

        for (int i = 1; i <= numCommands; i++) {
            String command = scanner.nextLine();
            String username = command.split("\\s+")[1];

            if (command.startsWith("register")) {
                String plateNumber = command.split("\\s+")[2];
                if (carsMap.containsKey(username)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", carsMap.get(username));
                } else {
                    carsMap.put(username, plateNumber);
                    System.out.printf("%s registered %s successfully%n", username, plateNumber);
                }
            } else if (command.startsWith("unregister")) {
                if (carsMap.containsKey(username)) {
                    System.out.printf("%s unregistered successfully%n", username);
                    carsMap.remove(username);
                } else {
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }

        }

        carsMap.forEach((key, value)-> System.out.println(key + " => " + value));

    }
}
