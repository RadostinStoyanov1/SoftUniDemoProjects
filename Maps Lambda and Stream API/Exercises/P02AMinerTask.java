package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            String currentResource = command;
            int resourceQuantity = Integer.parseInt(scanner.nextLine());

            resourcesMap.putIfAbsent(currentResource, 0);
            resourcesMap.put(currentResource, resourcesMap.get(currentResource) + resourceQuantity);

            command = scanner.nextLine();
        }

        resourcesMap.forEach((key, value)-> System.out.println(key + " -> " + value));

    }
}
