package P12Ararys_Exercises;

import java.util.Scanner;

public class P07MaxSequenceOfEqualElements2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputArr[i]);
        }

        int maxLength = 0;
        int length = 1;
        int startIndex = 0;
        int bestStartIndex = 0;

        for (int i = 1; i < inputIntArr.length; i++) {
            if (inputIntArr[i] == inputIntArr[i - 1]) {
                length++;
            } else {
                startIndex = i;
                length = 1;
            }

            if (length > maxLength) {
                maxLength = length;
                bestStartIndex = startIndex;
            }
        }

        for (int i = bestStartIndex; i < bestStartIndex + maxLength; i++) {
            System.out.print(inputIntArr[i] + " ");
        }


    }
}
