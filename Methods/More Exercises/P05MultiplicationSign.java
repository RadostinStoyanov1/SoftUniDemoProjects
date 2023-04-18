package P15Methods_More_Exercises;

import java.util.Scanner;

public class P05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        System.out.println(checkResult(num1, num2, num3));

    }

    public static String checkResult (int num1, int num2, int num3) {
        int negativeCounter = 0;
        if (num1 < 0) {
            negativeCounter++;
        }
        if (num2 < 0) {
            negativeCounter++;
        }
        if (num3 < 0) {
            negativeCounter++;
        }
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            return "zero";
        }

        if (negativeCounter == 0 || negativeCounter == 2) {
            return "positive";
        } else {
            return "negative";
        }

    }

}
