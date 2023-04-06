package P12Arrays_More_Exercises;

import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] outputArr = new int[0];

        for (int i = 1; i <= n; i++) {
            int[] currentArr = new int[outputArr.length + 1];
            for (int j = 0; j < currentArr.length; j++) {
                if (j == 0) {
                    currentArr[j] = 1;
                } else if (j == currentArr.length - 1) {
                    currentArr[j] = outputArr[j - 1];
                } else {
                    currentArr[j] = outputArr[j - 1] + outputArr[j];
                }
            }

            outputArr = currentArr;

            for (int item : outputArr) {
                System.out.print(item + " ");
            }

            System.out.println();

        }

    }
}
