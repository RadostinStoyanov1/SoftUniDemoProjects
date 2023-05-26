package P19ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialLoot = scanner.nextLine();
        List<String> pirateLoot = new ArrayList<>();
        pirateLoot = Arrays.stream(initialLoot.split("\\|")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            List<String> commandList = Arrays.stream(command.split(" ")).collect(Collectors.toList());

            switch (commandList.get(0)) {
                case "Loot":
                    for (int i = 1; i < commandList.size(); i++) {
                        if (!pirateLoot.contains(commandList.get(i))) {
                            pirateLoot.add(0, commandList.get(i));
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandList.get(1));
                    if (dropIndex >= 0 && dropIndex < pirateLoot.size()) {
                        String removeElement = pirateLoot.get(dropIndex);
                        pirateLoot.remove(dropIndex);
                        pirateLoot.add(removeElement);
                    }
                    break;
                case "Steal":
                    int numElements = Integer.parseInt(commandList.get(1));
                    if (numElements >= pirateLoot.size()) {
                        numElements = pirateLoot.size() - 1;
                    }
                    List<String> stolenElements = new ArrayList<>();
                    for (int i = pirateLoot.size() - 1; i > pirateLoot.size() - 1 - numElements; i--) {
                        stolenElements.add(pirateLoot.get(i));
                    }
                    for (int i = pirateLoot.size() - 1; i > pirateLoot.size() - 1 - numElements; i--) {
                        pirateLoot.remove(i);
                    }
                    Collections.reverse(stolenElements);
                    System.out.println(String.join(", ", stolenElements));

            }
            command = scanner.nextLine();
        }

        if (pirateLoot.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            for (String s : pirateLoot) {
                int currentLength = s.length();
                sum += currentLength;
            }
            double averageScore = sum / pirateLoot.size();
            System.out.printf("Average treasure gain: %.02f pirate credits.", averageScore);
        }

    }
}
