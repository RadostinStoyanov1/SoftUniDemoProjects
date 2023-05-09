package P17List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add":
                    intList = addIntegerElementInList(intList, Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    intList = removeElement(intList, Integer.parseInt(command[1]));
                    break;
                case "RemoveAt":
                    intList = removeElementAtIndex(intList, Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    intList = insertElementAtPosition(intList, Integer.parseInt(command[1]), Integer.parseInt(command[2]));

            }

            input = scanner.nextLine();
        }

        System.out.println(intList.toString().replace("[", "").replace("]", ""));

    }

    public static List<Integer> addIntegerElementInList (List<Integer> numbers, int element) {
        numbers.add(element);
        return numbers;
    }

    public static List<Integer> removeElementAtIndex (List<Integer> numbers, int index) {
        numbers.remove(index);
        return numbers;
    }

    public static List<Integer> removeElement (List<Integer> numbers, int num) {
        numbers.remove(Integer.valueOf(num));
        return numbers;
    }

    public static List<Integer> insertElementAtPosition (List<Integer> numbers, int num, int index) {
        numbers.add(index, num);
        return numbers;
    }

}
