package P29TextProcessing_Execise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        StringBuilder encryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            char encryptedChar = (char) ((int) c + 3);
            encryptedText.append(encryptedChar);
        }

        System.out.println(encryptedText.toString());

    }
}
