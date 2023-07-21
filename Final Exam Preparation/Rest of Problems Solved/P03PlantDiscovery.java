package P36FinalExamPreparation;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numPlants = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantsRarityMap = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRatingMap = new LinkedHashMap<>();

        for (int i = 1; i <= numPlants; i++) {
            String input = scanner.nextLine();
            String plantName = input.split("<->")[0];
            int plantRarity = Integer.parseInt(input.split("<->")[1]);
            plantsRarityMap.put(plantName, plantRarity);
            plantsRatingMap.putIfAbsent(plantName, new ArrayList<>());
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            if (command.startsWith("Rate: ")) {
                command = command.replace("Rate: ", "");
                String currentPlant = command.split(" - ")[0];
                double currentRating = Double.parseDouble(command.split(" - ")[1]);
                if (plantsRatingMap.containsKey(currentPlant)) {
                    plantsRatingMap.get(currentPlant).add(currentRating);
                } else {
                    System.out.println("error");
                }
            } else if (command.startsWith("Update: ")) {
                command = command.replace("Update: ", "");
                String currentPlant = command.split(" - ")[0];
                int currentRarity = Integer.parseInt(command.split(" - ")[1]);
                if (plantsRarityMap.containsKey(currentPlant)) {
                    plantsRarityMap.put(currentPlant, currentRarity);
                } else {
                    System.out.println("error");
                }
            } else if (command.startsWith("Reset: ")) {
                command = command.replace("Reset: ", "");
                String currentPlant = command;
                if (plantsRatingMap.containsKey(currentPlant)) {
                    plantsRatingMap.get(currentPlant).clear();
                } else {
                    System.out.println("error");
                }
            }

            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Double>> entry : plantsRatingMap.entrySet()) {
            String currentPlant = entry.getKey();
            double averageRating = entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            int rarity = plantsRarityMap.get(currentPlant);

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", currentPlant, rarity, averageRating);
        }

    }
}
