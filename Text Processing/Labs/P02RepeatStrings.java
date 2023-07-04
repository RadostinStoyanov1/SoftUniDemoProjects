package P28TextProcessing_Lab;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArr = scanner.nextLine().split(" ");
        String output = "";

        for (int i = 0; i < wordsArr.length; i++) {
            String currentWord = wordsArr[i];
            String concatenatedWord = "";
            for (int j = 1; j <= currentWord.length(); j++) {
                concatenatedWord += currentWord;
            }
            output += concatenatedWord;
        }

        System.out.println(output);

    }
}
