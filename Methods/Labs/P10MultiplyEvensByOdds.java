package P14Methods;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int sumOdds = sumOfOdds(input);
        int sumEvens = sumOfEvens(input);

        System.out.println(sumOdds * sumEvens);

    }

    private static int sumOfOdds(int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num > 0) {
            if ((num % 10) % 2 != 0) {
                sum += num % 10;
            }
            num /= 10;
        }
        return sum;
    }

    private static int sumOfEvens(int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num > 0) {
            if ((num % 10) % 2 == 0) {
                sum += num % 10;
            }
            num /= 10;
        }
        return sum;
    }

}
