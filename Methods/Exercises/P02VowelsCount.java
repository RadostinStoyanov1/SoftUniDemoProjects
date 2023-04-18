package P15Methods_Exercises;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printVowelsCount(input);

    }

    public static void printVowelsCount (String input) {
        int vowelsCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'A' || input.charAt(i) == 'e' || input.charAt(i) == 'E' || input.charAt(i) == 'i' ||
                    input.charAt(i) == 'I' || input.charAt(i) == 'o' || input.charAt(i) == 'O' || input.charAt(i) == 'u' || input.charAt(i) == 'U') {
                vowelsCounter++;
            }
        }
        System.out.println(vowelsCounter);
    }

}
