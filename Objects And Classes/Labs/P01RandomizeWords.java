package P22ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] wordArr = input.split(" ");

        Random rnd = new Random();

        for (int i = 0; i < wordArr.length; i++) {
            int firstIndex = rnd.nextInt(wordArr.length);
            int secondIndex = rnd.nextInt(wordArr.length);

            String tempWord = wordArr[secondIndex];
            wordArr[secondIndex] = wordArr[firstIndex];
            wordArr[firstIndex] = tempWord;
        }

        System.out.println(String.join(System.lineSeparator(), wordArr));

    }
}
