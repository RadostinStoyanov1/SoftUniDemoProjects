package P29TextProcessing_More_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequenceOfKeys = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder input = new StringBuilder(scanner.nextLine());

        while (!input.toString().equals("find")) {
            int keyCounter = 0;
            for (int i = 0; i < input.length(); i++) {
                input = changeSymbol(input, sequenceOfKeys, i, keyCounter);

                keyCounter++;
                if (keyCounter == sequenceOfKeys.length) {
                    keyCounter = 0;
                }
            }

            String[] temp = input.toString().split("\\&");
            String treasure = temp[1];
            String[] temp1 = input.toString().split("[<>]");
            String coordinates = temp1[1];
            System.out.printf("Found %s at %s%n", treasure, coordinates);

            input.setLength(0);
            input.append(scanner.nextLine());
        }

    }

    public static StringBuilder changeSymbol(StringBuilder input, int[] sequenceOfKeys, int i, int keyCounter) {
        char currentChar = input.charAt(i);
        int decreaseNum = sequenceOfKeys[keyCounter];
        int newCharCode = (int)currentChar - decreaseNum;
        char newChar = (char)newCharCode;
        String forInput = "" + newChar;
        input.replace(i, i + 1, forInput);
        return input;
    }

}
