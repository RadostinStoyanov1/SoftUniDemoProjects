package P12Arrays_More_Exercises;

import java.util.Scanner;

public class P03RecursiveFibonacciWithArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] fibonacciArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                fibonacciArr[i] = 1;
            } else {
                fibonacciArr[i] = fibonacciArr[i - 2] + fibonacciArr[i - 1];
            }
        }
        System.out.println(fibonacciArr[n - 1]);

    }

}
