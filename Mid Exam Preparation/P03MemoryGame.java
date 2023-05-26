package P19ExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequenceOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        int movesCounter = 0;
        boolean isWin = false;

        while (!command.equals("end")) {
            int firstIndex = Integer.parseInt(command.split(" ")[0]);
            int secondIndex = Integer.parseInt(command.split(" ")[1]);
            movesCounter++;

            if (firstIndex == secondIndex || firstIndex < 0 || secondIndex < 0 || firstIndex >= sequenceOfNumbers.size() || secondIndex >= sequenceOfNumbers.size()) {
                String elementToAdd = "" + "-" + movesCounter + "a";
                System.out.println("Invalid input! Adding additional elements to the board");
                sequenceOfNumbers.add(sequenceOfNumbers.size() / 2, elementToAdd);
                sequenceOfNumbers.add(sequenceOfNumbers.size() / 2, elementToAdd);
            } else if (sequenceOfNumbers.get(firstIndex).equals(sequenceOfNumbers.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", sequenceOfNumbers.get(firstIndex));
                if (firstIndex < secondIndex) {
                    sequenceOfNumbers.remove(secondIndex);
                    sequenceOfNumbers.remove(firstIndex);
                } else {
                    sequenceOfNumbers.remove(firstIndex);
                    sequenceOfNumbers.remove(secondIndex);
                }

                if (sequenceOfNumbers.isEmpty()) {
                    isWin = true;
                    break;
                }
            } else {
                System.out.println("Try again!");
            }


            command = scanner.nextLine();
        }

        if (isWin) {
            System.out.printf("You have won in %d turns!%n", movesCounter);
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", sequenceOfNumbers));
        }

    }

}
