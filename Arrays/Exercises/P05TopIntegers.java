package P12Ararys_Exercises;

import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStringArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputStringArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);
        }

        for (int i = 0; i < inputIntArr.length; i++) {
            boolean isHighest = false;
            for (int j = i + 1; j < inputIntArr.length; j++) {
                if (inputIntArr[i] > inputIntArr[j]) {
                    isHighest = true;
                } else {
                    isHighest = false;
                    break;
                }
            }

            if (isHighest || i == (inputIntArr.length - 1)) {
                System.out.print(inputIntArr[i] + " ");
            }
        }

    }
}
