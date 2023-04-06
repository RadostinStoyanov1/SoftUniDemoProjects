package P12Ararys_Exercises;

import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStringArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputStringArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);
        }

        int previousElement = 0;
        int previousLongestSequenceCounter = 1;
        int currentLongestSequenceCounter = 1;
        int repeatedDigitInLongestSequence = 0;

        for (int i = 0; i < inputIntArr.length; i++) {
            if (i == 0) {
                previousElement = inputIntArr[0];
                continue;
            } else if (inputIntArr[i] == previousElement) {
                currentLongestSequenceCounter++;
                if (currentLongestSequenceCounter > previousLongestSequenceCounter) {
                    previousLongestSequenceCounter = currentLongestSequenceCounter;
                    repeatedDigitInLongestSequence = inputIntArr[i];
                }
            } else if (inputIntArr[i] != previousElement) {
                currentLongestSequenceCounter = 1;
                previousElement = inputIntArr[i];
            }
        }

        String longestSequence = String.format("%d ", repeatedDigitInLongestSequence);
        System.out.println(longestSequence.repeat(previousLongestSequenceCounter));

    }
}
