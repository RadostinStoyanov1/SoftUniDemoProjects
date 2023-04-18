package P14Methods;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (action) {
            case "add":
                adding(firstNum, secondNum);
                break;
            case "subtract":
                subtracting(firstNum, secondNum);
                break;
            case "multiply":
                multiplying(firstNum, secondNum);
                break;
            case "divide":
                dividing(firstNum, secondNum);

        }

    }

    public static void adding(int a, int b) {
        System.out.println(a + b);
    }

    public static void subtracting(int a, int b) {
        System.out.println(a - b);
    }

    public static void multiplying(int a, int b) {
        System.out.println(a * b);
    }

    public static void dividing(int a, int b) {
        System.out.println(a / b);
    }

}
