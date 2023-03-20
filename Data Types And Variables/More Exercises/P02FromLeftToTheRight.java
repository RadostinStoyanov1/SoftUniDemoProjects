package P09dataTypesAndVariables_More_Exercises;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            Scanner type = new Scanner(input);

            long leftNumber = type.nextLong();
            long rightNumber = type.nextLong();

            long sumOfDigits = 0;

            if (leftNumber > rightNumber) {
                leftNumber = Math.abs(leftNumber);
                while (leftNumber > 0) {
                    sumOfDigits += leftNumber % 10;
                    leftNumber /= 10;
                }
                System.out.println(sumOfDigits);
            } else  {
                rightNumber = Math.abs(rightNumber);
                while (rightNumber > 0) {
                    sumOfDigits += rightNumber % 10;
                    rightNumber /= 10;
                }
                System.out.println(sumOfDigits);
            }

        }

    }
}
