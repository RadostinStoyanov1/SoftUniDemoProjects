package P11Arrays;

import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int [] inputIntArr = new int[input.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(input[i]);
        }

        int[] condensedArray = new int[inputIntArr.length - 1];

        for (int i = 0; i < inputIntArr.length; i++) {
            if (inputIntArr.length == 1) {
                break;
            }

            if (i == inputIntArr.length - 1) {
                int[] newCondensedArray = new int[condensedArray.length - 1];
                inputIntArr = condensedArray;
                condensedArray = newCondensedArray;
                i = -1;
            } else {
                condensedArray[i] = inputIntArr[i] + inputIntArr[i + 1];
            }
        }

        System.out.println(inputIntArr[0]);

    }
}
