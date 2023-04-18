package P15Methods_More_Exercises;

import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] tribonacciSequence = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            switch (i) {
                case 0:
                    tribonacciSequence[i] = 0;
                    break;
                case 1:
                case 2:
                    tribonacciSequence[i] = 1;
                    break;
                default:
                    tribonacciSequence[i] = tribonacciN(tribonacciSequence[i - 1], tribonacciSequence[i - 2], tribonacciSequence[i - 3]);
            }
        }

        for (int i = 1; i <= num; i++) {
            System.out.print(tribonacciSequence[i] + " ");
        }

    }

    public static int tribonacciN (int n1, int n2, int n3) {
        int result = n1 + n2 + n3;
        return result;
    }

}
