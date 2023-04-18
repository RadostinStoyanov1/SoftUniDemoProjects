package P15Methods_Exercises;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            boolean divBy8 = divBy8(i);
            if (!divBy8) {
                continue;
            }
            boolean oneOddDigit = oneOddDigit(i);
            if (!oneOddDigit) {
                continue;
            }
            System.out.println(i);
        }

    }

    public static boolean divBy8 (int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean oneOddDigit (int num) {
        while (num > 0) {
            int currentDigit = num % 10;
            if (currentDigit % 2 != 0) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

}
