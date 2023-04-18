package P15Methods_Exercises;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sumOfTwoNumbers = sum(firstNum, secondNum);

        int result = subtract(sumOfTwoNumbers, thirdNum);

        System.out.println(result);

    }

    public static int sum (int num1, int num2) {
        return num1 + num2;
    }

    public static int subtract (int num1, int num2) {
        return num1 - num2;
    }

}
