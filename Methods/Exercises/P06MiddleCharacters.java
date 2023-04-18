package P15Methods_Exercises;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleChar(input);

    }

    public static void printMiddleChar (String input) {
        char[] inputArr = input.toCharArray();
        if (inputArr.length % 2 == 0) {
            System.out.print(inputArr[((inputArr.length) / 2) - 1]);
            System.out.print(inputArr[inputArr.length / 2]);
        } else {
            System.out.println(inputArr[inputArr.length / 2]);
        }
    }

}
