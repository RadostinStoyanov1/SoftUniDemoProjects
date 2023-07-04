package P28TextProcessing_Lab;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWordsArr = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : bannedWordsArr) {
            String replacement = repeatString(banWord.length());
            if (text.contains(banWord)) {
                text = text.replace(banWord, replacement);
            }
        }

        System.out.println(text);

    }

    public static String repeatString(int numChars) {
        String result = "";
        for (int i = 1; i <= numChars; i++) {
            result += "*";
        }
        return result;
    }

}
