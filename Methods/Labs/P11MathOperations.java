package P14Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        char action = scanner.nextLine().charAt(0);
        int secondNum = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.##");

        double output = result(firstNum, action, secondNum);

        System.out.println(df.format(output));


    }

    public static double result (int num1, char action, int num2) {
        double result = 0;
        switch (action) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = (double)num1 / num2;
        }
        return result;
    }
}
