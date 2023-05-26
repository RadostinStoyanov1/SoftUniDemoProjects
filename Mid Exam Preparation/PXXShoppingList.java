package P20ExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PXXShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            if (command.startsWith("Urgent")) {
                shoppingList = addElement(shoppingList, command);
            } else if (command.startsWith("Unnecessary")) {
                shoppingList = removeElement(shoppingList, command);
            } else if (command.startsWith("Correct")) {
                shoppingList = correctElementWithAnotherOne(shoppingList, command);
            } else if (command.startsWith("Rearrange")) {
                shoppingList = rearrangeElement(shoppingList, command);
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", shoppingList));

    }

    public static List<String> addElement(List<String> shoppingList, String command) {
        String element = command.split(" ")[1];
        if (!shoppingList.contains(element)) {
            shoppingList.add(0, element);
        }
        return shoppingList;
    }

    public static List<String> removeElement(List<String> shoppingList, String command) {
        String element = command.split(" ")[1];
        if (shoppingList.contains(element)) {
            shoppingList.remove(element);
        }
        return shoppingList;
    }

    public static List<String> correctElementWithAnotherOne(List<String> shoppingList, String command) {
        String oldElement = command.split(" ")[1];
        String newElement = command.split(" ")[2];
        if (shoppingList.contains(oldElement)) {
            Collections.replaceAll(shoppingList, oldElement, newElement);
        }
        return shoppingList;
    }

    public static List<String> rearrangeElement(List<String> shoppingList, String command) {
        String element = command.split(" ")[1];
        if (shoppingList.contains(element)) {
            shoppingList.remove(element);
            shoppingList.add(element);
        }
        return shoppingList;
    }

}
