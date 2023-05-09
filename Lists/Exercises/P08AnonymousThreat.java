package P18List_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            if (command.startsWith("merge")) {
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);
                if ((startIndex < 0 && endIndex < 0) || (startIndex > inputList.size() - 1 && endIndex > inputList.size() - 1)) {
                    command = scanner.nextLine();
                    continue;
                } else if (startIndex < 0 && endIndex > inputList.size() - 1) {
                    startIndex = 0;
                    endIndex = inputList.size() - 1;
                } else if (startIndex < 0 && endIndex <= inputList.size() - 1) {
                    startIndex = 0;
                } else if (startIndex >= 0 && endIndex > inputList.size() - 1) {
                    endIndex = inputList.size() - 1;
                }
                inputList = mergeElements(inputList, startIndex, endIndex);
            } else if (command.startsWith("divide")) {
                inputList = divideElement(inputList, command);
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", inputList));

    }

    public static List<String> mergeElements(List<String> inputList, int startIndex, int endIndex) {
        String concatenatedElements = "";
        for (int i = startIndex; i <= endIndex; i++) {
            concatenatedElements += inputList.get(startIndex);
            inputList.remove(startIndex);
        }
        inputList.add(startIndex, concatenatedElements);
        return inputList;
    }

    public static List<String> divideElement(List<String> inputList, String command) {
        int divideIndex = Integer.parseInt(command.split(" ")[1]);
        if (divideIndex < 0 || divideIndex > inputList.size() - 1) {
            return inputList;
        }
        int numPartitions = Integer.parseInt(command.split(" ")[2]);
        String dividedElement = inputList.get(divideIndex);
        int partitionLength = dividedElement.length() / numPartitions;

        int counterOfElements = 0;
        int counterOfSymbols = 0;
        String concatenatedSymbols = "";
        List<String> listToBeAdded = new ArrayList<>();
        for (int i = 0; i < dividedElement.length(); i++) {
            concatenatedSymbols += dividedElement.charAt(i);
            counterOfSymbols++;
            if (counterOfElements == numPartitions - 1 && dividedElement.length() % numPartitions != 0 && counterOfSymbols == 1) {
                partitionLength += dividedElement.length() % numPartitions;
            }
            if (counterOfSymbols == partitionLength) {
                listToBeAdded.add(concatenatedSymbols);
                counterOfElements++;
                concatenatedSymbols = "";
                counterOfSymbols = 0;
            }
        }

        inputList.remove(divideIndex);

        for (int i = listToBeAdded.size() - 1; i >= 0; i--) {
            inputList.add(divideIndex, listToBeAdded.get(i));
        }

        return inputList;

    }

}
