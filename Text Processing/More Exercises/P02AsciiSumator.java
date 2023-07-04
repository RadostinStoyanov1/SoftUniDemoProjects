package P29TextProcessing_More_Exercise;

import java.util.Scanner;

public class P02AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        String randomText = scanner.nextLine();

        int sumOfChars = 0;

        for (char symbol : randomText.toCharArray()) {
            if (firstChar < secondChar) {
                if (symbol > firstChar && symbol < secondChar) {
                    sumOfChars += (int) symbol;
                }
            } else {
                if (symbol < secondChar || symbol > firstChar) {
                    sumOfChars += (int) symbol;
                }
            }

        }

        System.out.println(sumOfChars);

    }
}
