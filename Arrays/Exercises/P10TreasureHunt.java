package P12Ararys_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialLoot = scanner.nextLine().split("\\|");

        String command = scanner.nextLine();

        while(!command.equals("Yohoho!")) {
            String[] commandArr = command.split(" ");
            String commandType = commandArr[0];

            switch (commandType) {
                case "Loot":
                    for (int i = 1; i < commandArr.length; i++) {
                        int differenceCounter = 0;
                        for (int j = 0; j < initialLoot.length; j++) {
                            if (commandArr[i].equals(initialLoot[j])) {
                                break;
                            } else {
                                differenceCounter++;
                            }
                        }
                        if (differenceCounter == initialLoot.length) {
                            String[] newLootArray = new String[initialLoot.length + 1];
                            newLootArray[0] = commandArr[i];
                            for (int k = 1; k <= initialLoot.length; k++) {
                                newLootArray[k] = initialLoot[k - 1];
                            }
                            initialLoot = newLootArray;
                        }
                    }
                    break;
                case "Drop":
                    int commandArr1stElement = Integer.parseInt(commandArr[1]);
                    if (commandArr1stElement >= 0 && commandArr1stElement < initialLoot.length) {
                        String currentNumForLastElement = initialLoot[Integer.parseInt(commandArr[1])];
                        String currentElement = "";
                        for (int i = Integer.parseInt(commandArr[1]); i < initialLoot.length; i++) {
                            if (i == initialLoot.length - 1) {
                                initialLoot[initialLoot.length - 1] = currentNumForLastElement;
                            } else {
                                currentElement = initialLoot[i + 1];
                                initialLoot[i] = initialLoot[i + 1];
                            }

                        }
                    }
                    break;
                case "Steal":
                    int itemsToBeRemoved = Integer.parseInt(commandArr[1]);
                    int initialLootAvailableItems = initialLoot.length;

                    if (itemsToBeRemoved < initialLootAvailableItems) {
                        String[] removedItems = new String[itemsToBeRemoved];
                        for (int i = initialLoot.length - itemsToBeRemoved; i < initialLoot.length; i++) {
                            removedItems[(i - (initialLoot.length - itemsToBeRemoved))] = initialLoot[i];
                        }

                        System.out.println(Arrays.toString(removedItems).replace("[", "").replace("]", ""));

                        String[] newLootArray = new String[initialLoot.length - removedItems.length];
                        for (int i = 0; i < newLootArray.length; i++) {
                            newLootArray[i] = initialLoot[i];
                        }
                        initialLoot = newLootArray;
                    } else {
                        System.out.println(Arrays.toString(initialLoot).replace("[", "").replace("]", ""));
                        String[] zeroArray = new String[0];
                        initialLoot = zeroArray;
                    }
            }

            command = scanner.nextLine();
        }

        double sum = 0;

        for (int i = 0; i < initialLoot.length; i++) {
            String currentString = initialLoot[i];
            sum += currentString.length();
        }

        double lootResult = sum / initialLoot.length;

        if (initialLoot.length == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", lootResult);
        }

    }
}
