package P20ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class PXXShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();
        int shotTargetsCounter = 0;

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);
            if (index >= 0 && index < numbersArr.length && numbersArr[index] != -1) {
                int elementValue = numbersArr[index];
                numbersArr[index] = -1;
                for (int i = 0; i < numbersArr.length; i++) {
                    if (numbersArr[i] == -1) {
                        continue;
                    }

                    if (numbersArr[i] > elementValue) {
                        numbersArr[i] -= elementValue;
                    } else {
                        numbersArr[i] += elementValue;
                    }

                }
            } else {
                command = scanner.nextLine();
                continue;
            }
            shotTargetsCounter++;
            command = scanner.nextLine();
        }

        String targets = Arrays.toString(numbersArr).replace("[", "").replace(",", "").replace("]", "");
        System.out.printf("Shot targets: %d -> %s%n", shotTargetsCounter, targets);

    }
}
