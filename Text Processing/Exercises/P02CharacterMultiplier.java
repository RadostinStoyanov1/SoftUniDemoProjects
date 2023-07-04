package P29TextProcessing_Execise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String string1 = input.split(" ")[0];
        String string2 = input.split(" ")[1];
        int sum = 0;

        if (string1.length() >= string2.length()) {
            for (int i = 0; i < string1.length(); i++) {
                char char1 = string1.charAt(i);
                char char2 = ' ';
                if (i <= string2.length() - 1) {
                    char2 = string2.charAt(i);
                } else {
                    char2 = 1;
                }
                sum += multiplyChars(char1, char2);
            }
        } else {
            for (int i = 0; i < string2.length(); i++) {
                char char1 = ' ';
                char char2 = string2.charAt(i);
                if (i <= string1.length() - 1) {
                    char1 = string1.charAt(i);
                } else {
                    char1 = 1;
                }
                sum += multiplyChars(char1, char2);
            }
        }
        System.out.println(sum);
    }

    public static int multiplyChars(char char1, char char2) {
        int result = 0;
        int num1 = (int)char1;
        int num2 = (int)char2;
        result = num1 * num2;
        return result;
    }

}
