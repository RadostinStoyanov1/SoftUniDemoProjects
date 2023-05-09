package P18List_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.startsWith("Add")) {
                numbersList = addNumberAtTheEnd(numbersList, command);
            } else if (command.startsWith("Insert")) {
                numbersList = insertElementAaIndex(numbersList, command);
            } else if (command.startsWith("Remove")) {
                numbersList = removeIndex(numbersList, command);
            } else if (command.contains("Shift left")) {
                numbersList = firstNumberBecomesLast(numbersList, command);
            } else if (command.contains("Shift right")) {
                numbersList = lastNumBecomesFirst(numbersList, command);
            }

            command = scanner.nextLine();
        }

        for (Integer num : numbersList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static List<Integer> addNumberAtTheEnd (List<Integer> numbersList, String command) {
        int elementToAdd = Integer.parseInt(command.split(" ")[1]);
        numbersList.add(elementToAdd);
        return numbersList;
    }

    public static List<Integer> insertElementAaIndex(List<Integer> numbersList, String command) {
        int elementToAdd = Integer.parseInt(command.split(" ")[1]);
        int indexToAdd = Integer.parseInt(command.split(" ")[2]);
        if (indexToAdd < 0 || indexToAdd > numbersList.size() - 1) {
            System.out.println("Invalid index");
        } else {
            numbersList.add(indexToAdd, elementToAdd);
        }
        return numbersList;
    }

    public static List<Integer> removeIndex(List<Integer> numbersList, String command) {
        int indexToBeDeleted = Integer.parseInt(command.split(" ")[1]);
        if (indexToBeDeleted < 0 || indexToBeDeleted > numbersList.size() - 1) {
            System.out.println("Invalid index");
        } else {
            numbersList.remove(indexToBeDeleted);
        }
        return numbersList;
    }
    
    public static List<Integer> firstNumberBecomesLast (List<Integer> numbersList, String command) {
        int n = Integer.parseInt(command.split(" ")[2]);
        for (int i = 0; i < n; i++) {
           int numToBeAddedAtEnd = numbersList.get(0);
           numbersList.remove(0);
           numbersList.add(numToBeAddedAtEnd);
        }
        return numbersList;
    }

    public static List<Integer> lastNumBecomesFirst(List<Integer> numbersList, String command) {
        int n = Integer.parseInt(command.split(" ")[2]);
        for (int i = 0; i < n; i++) {
            int numToBeAddedAtBeginning = numbersList.get(numbersList.size() - 1);
            numbersList.remove(numbersList.size() - 1);
            numbersList.add(0, numToBeAddedAtBeginning);
        }
        return numbersList;
    }
    
}
