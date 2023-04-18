package P15Methods_Exercises;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        long factorialNum1 = factorial(num1);
        long factorialNum2 = factorial(num2);

        double result = factorialNum1 * 1.0 / factorialNum2;

        System.out.printf("%.2f", result);

    }

    public static long factorial (int num) {
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
