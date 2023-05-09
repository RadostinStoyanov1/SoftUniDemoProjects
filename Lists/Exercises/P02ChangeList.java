package P18List_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if(command.startsWith("Delete")) {
                numbers = deleteEveryNumNElementsInList(numbers, command);
            } else if (command.startsWith("Insert")) {
                numbers = insertElementAtIndex(numbers, command);
            }
            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replace("[", "").replace("]", "").replaceAll(",", ""));

    }

    public static List<Integer> deleteEveryNumNElementsInList (List<Integer> numbers, String command) {
        int numToBeDeleted = Integer.parseInt(command.split(" ")[1]);
        numbers.removeAll(Arrays.asList(numToBeDeleted));
        return numbers;
    }

    public static List<Integer> insertElementAtIndex(List<Integer> numbers, String command) {
        int numToBeAdded = Integer.parseInt(command.split(" ")[1]);
        int indexToBeAdded = Integer.parseInt(command.split(" ")[2]);
        numbers.add(indexToBeAdded, numToBeAdded);
        return numbers;
    }

}
