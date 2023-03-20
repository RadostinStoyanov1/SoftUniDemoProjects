package P06BasicSyntaxConditionalStatementsAndLoops_More_Exercizes;

import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int highestNumber = Integer.MIN_VALUE;
        int lowestNumber = Integer.MAX_VALUE;
        int middleNumber = 0;

        if (firstNumber > secondNumber) {
            highestNumber = firstNumber;
            lowestNumber = secondNumber;
            if (firstNumber > thirdNumber) {
                if (secondNumber > thirdNumber) {
                    middleNumber = secondNumber;
                    lowestNumber = thirdNumber;
                } else {
                    middleNumber = secondNumber;
                }
            } else {
                highestNumber = thirdNumber;
                middleNumber = firstNumber;
                lowestNumber = secondNumber;
            }
        } else {
            if (secondNumber > thirdNumber) {
                highestNumber = secondNumber;
                if (thirdNumber > firstNumber) {
                    middleNumber = thirdNumber;
                    lowestNumber = firstNumber;
                } else {
                    middleNumber = firstNumber;
                    lowestNumber = thirdNumber;
                }
            } else {
                highestNumber = thirdNumber;
                middleNumber = secondNumber;
                lowestNumber = firstNumber;
            }
        }

        System.out.println(highestNumber);
        System.out.println(middleNumber);
        System.out.println(lowestNumber);


    }
}
