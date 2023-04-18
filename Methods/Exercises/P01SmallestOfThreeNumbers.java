package P15Methods_Exercises;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        System.out.println(lowestOfThreeNumbers(firstNum, secondNum, thirdNum));

    }

    public static int lowestOfThreeNumbers(int num1, int num2, int num3) {
        int lowestNum = Integer.MAX_VALUE;
        if (num1 < lowestNum) {
            lowestNum = num1;
        }
        if (num2 < lowestNum) {
            lowestNum = num2;
        }
        if (num3 < lowestNum) {
            lowestNum = num3;
        }
        return lowestNum;
    }

}
