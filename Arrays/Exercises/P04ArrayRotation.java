package P12Ararys_Exercises;

import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStringArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputStringArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);
        }

        int n= Integer.parseInt(scanner.nextLine());
        int currentElement = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = inputIntArr.length - 1; j >= 0; j--) {
                if (j == (inputIntArr.length - 1)) {
                    currentElement = inputIntArr[j];
                    inputIntArr[j] = inputIntArr[0];
                } else {
                    int tempLastElement = inputIntArr[j];
                    inputIntArr[j] = currentElement;
                    currentElement = tempLastElement;
                }
            }
        }

        for (int i : inputIntArr) {
            System.out.print(i + " ");
        }

    }
}
