package P15Methods_Exercises;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        printCharsRow(first, second);

    }

    public static void printCharsRow (char one, char two) {
        if (one < two) {
            for (int i = (int) one + 1; i < (int) two; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = (int) two + 1; i < (int) one; i++) {
                System.out.print((char) i + " ");
            }
        }
        System.out.println();
    }

}
