package P14Methods;

import java.util.Scanner;

public class P01SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        printSign(num);

    }

    public static void printSign(int num) {
        String signText = "";
        if (num < 0) {
            signText = "negative";
        } else if (num > 0) {
            signText = "positive";
        } else {
            signText = "zero";
        }

        System.out.printf("The number %d is %s.%n", num, signText);

    }

}
