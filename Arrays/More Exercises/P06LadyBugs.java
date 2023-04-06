package P12Arrays_More_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldLength = Integer.parseInt(scanner.nextLine());
        int[] bugIndexesInput = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(е -> Integer.parseInt(е)).toArray();

        int[] field = new int[fieldLength];

        for (int i = 0; i < bugIndexesInput.length; i++) {
            if (bugIndexesInput[i] >= 0 && bugIndexesInput[i] <= field.length - 1) {
                field[bugIndexesInput[i]] = 1;
            }
        }

        String command = scanner.nextLine();
        
        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");
            int index = Integer.parseInt(commandArr[0]);
            String direction = commandArr[1];
            int numSteps = Integer.parseInt(commandArr[2]);
            
            if (index >= 0 && index <= field.length - 1 && field[index] == 1) {
                field[index] = 0;
                if (direction.equals("left")) {
                    if (index - numSteps >= 0) {
                        index -= numSteps;
                        while (index >= 0 && field[index] == 1) {
                            index -= numSteps;
                        }
                        if (index >= 0) {
                            field[index] = 1;
                        }
                    }
                } else if (direction.equals("right")) {
                    if (index + numSteps <= field.length - 1) {
                        index += numSteps;
                        while (index <= field.length - 1 && field[index] == 1) {
                            index += numSteps;
                        }
                        if (index <= field.length - 1) {
                            field[index] = 1;
                        }
                    }

                }
            }
            
            
            command = scanner.nextLine();
        }

        for (int i : field) {
            System.out.print(i + " ");
        }

    }
}
