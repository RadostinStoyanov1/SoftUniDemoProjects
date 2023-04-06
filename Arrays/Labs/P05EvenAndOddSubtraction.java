package P11Arrays;

import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStringArr = scanner.nextLine().split(" ");

        int[] inputIntArr = new int[inputStringArr.length];

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < inputStringArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);

            if (inputIntArr[i] % 2 == 0) {
                evenSum += inputIntArr[i];
            } else {
                oddSum += inputIntArr[i];
            }
        }

        System.out.println(evenSum - oddSum);



    }
}
