package P12Ararys_Exercises;

import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStringArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputStringArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);
        }

        boolean isElementPrinted = false;

        for (int i = 0; i < inputIntArr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += inputIntArr[j];
            }
            if (i == 0) {
                leftSum = 0;
            }

            for (int j = i + 1; j < inputIntArr.length; j++) {
                rightSum += inputIntArr[j];
            }
            if (i == (inputIntArr.length - 1)) {
                rightSum = 0;
            }

            if (leftSum == rightSum) {
                System.out.print(i + " ");
                isElementPrinted = true;
            }

        }

        if (!isElementPrinted) {
            System.out.println("no");
        }

    }
}
