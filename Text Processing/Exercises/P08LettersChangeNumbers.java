package P29TextProcessing_Execise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] codesArr = input.split("\\s+");
        double totalResult = 0;

        for (String code : codesArr) {
            StringBuilder command = new StringBuilder(code);
            String letterBefore = "" + command.charAt(0);
            int positionBefore = getAlphabeticPosition(letterBefore);
            command.replace(0, 1, "");
            String letterAfter = "" + command.charAt(command.length() - 1);
            int positionAfter = getAlphabeticPosition(letterAfter);
            command.replace(command.length() - 1, command.length(), "");
            String num = command.toString();
            double number = Double.parseDouble(num);
            double currentSum = 0;

            if (Character.isUpperCase(letterBefore.charAt(0))) {
                currentSum = number / positionBefore;
            } else {
                currentSum = number * positionBefore;
            }

            if (Character.isUpperCase(letterAfter.charAt(0))) {
                currentSum -= positionAfter;
            } else {
                currentSum += positionAfter;
            }

            totalResult += currentSum;

        }

        System.out.printf("%.2f%n", totalResult);

    }

    public static int getAlphabeticPosition(String letter) {
        letter = letter.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int position = alphabet.indexOf(letter) + 1;
        return position;
    }

}
