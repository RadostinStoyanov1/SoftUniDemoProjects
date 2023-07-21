package P36FinalExamPreparation;

import java.util.*;

public class P03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> citiesMap = new LinkedHashMap<>();
        String data = scanner.nextLine();

        while (!data.equals("Sail")) {
            String city = data.split("\\|\\|")[0];
            int population = Integer.parseInt(data.split("\\|\\|")[1]);
            int gold = Integer.parseInt(data.split("\\|\\|")[2]);

            if (citiesMap.containsKey(city)){
                int newPopulation = citiesMap.get(city).get(0) + population;
                int newGold = citiesMap.get(city).get(1) + gold;
                citiesMap.get(city).set(0, newPopulation);
                citiesMap.get(city).set(1, newGold);
            } else {
                citiesMap.put(city, new ArrayList<>());
                citiesMap.get(city).add(population);
                citiesMap.get(city).add(gold);
            }

            data = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String city = command.split("=>")[1];
            if (command.startsWith("Plunder")) {
                int people = Integer.parseInt(command.split("=>")[2]);
                int gold = Integer.parseInt(command.split("=>")[3]);
                citiesMap.get(city).set(0, citiesMap.get(city).get(0) - people);
                citiesMap.get(city).set(1, citiesMap.get(city).get(1) - gold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);

                if (citiesMap.get(city).get(0) == 0 || citiesMap.get(city).get(1) == 0) {
                    System.out.printf("%s has been wiped off the map!%n", city);
                    citiesMap.remove(city);
                }

            } else if (command.startsWith("Prosper")) {
                int gold = Integer.parseInt(command.split("=>")[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                    command = scanner.nextLine();
                    continue;
                }

                citiesMap.get(city).set(1, citiesMap.get(city).get(1) + gold);
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city, citiesMap.get(city).get(1));
            }

            command = scanner.nextLine();
        }

        if (citiesMap.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());
            for (Map.Entry<String, List<Integer>> entry : citiesMap.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        }

    }
}
