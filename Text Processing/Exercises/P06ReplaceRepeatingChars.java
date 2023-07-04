package P29TextProcessing_Execise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i -1) == text.charAt(i)) {
                text.replace(i, i + 1, "");
                i--;
            }
        }

        System.out.println(text);

    }
}
