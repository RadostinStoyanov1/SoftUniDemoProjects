package P12Arrays_More_Exercises;

import java.util.Scanner;

public class P03RecursiveFibonacciWithDynamicProgramming {

    static int fib(int number) {
        int[] fibonacci = new int[number + 1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= number; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        return fibonacci[number];

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fib(n));

    }
}
