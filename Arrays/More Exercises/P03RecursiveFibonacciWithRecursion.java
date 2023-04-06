package P12Arrays_More_Exercises;

import java.util.Scanner;

public class P03RecursiveFibonacciWithRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n));

    }

    static int fibonacci(int number) {
        if (number <= 1) {
            return number;
        } else {
            return fibonacci(number - 2) + fibonacci(number - 1);
        }
    }

}
