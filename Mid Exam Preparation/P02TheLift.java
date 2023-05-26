package P20ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTouristsWaiting = Integer.parseInt(scanner.nextLine());
        int[] liftSpace = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean liftIsFull = false;

        while (numTouristsWaiting > 0) {
            int numberOfFullWagons = 0;
            for (int i = 0; i < liftSpace.length; i++) {
                if (liftSpace[i] >= 4) {
                    numberOfFullWagons++;
                } else {
                    liftSpace[i] += 1;
                    numTouristsWaiting --;
                    if (liftSpace[i] >= 4) {
                        numberOfFullWagons++;
                    }
                    break;
                }
            }

            if (numberOfFullWagons == liftSpace.length) {
                liftIsFull = true;
                break;
            }
        }

        String[] output = new String[liftSpace.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = "" + liftSpace[i];
        }

        if (numTouristsWaiting == 0 && !liftIsFull) {
            System.out.println("The lift has empty spots!");
            System.out.println(String.join(" ", output));
        } else if (numTouristsWaiting > 0 && liftIsFull) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", numTouristsWaiting);
            System.out.println(String.join(" ", output));
        } else if (numTouristsWaiting == 0 && liftIsFull) {
            System.out.println(String.join(" ", output));
        }



    }
}
