package P09dataTypesAndVariables_More_Exercises;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int numChars = Integer.parseInt(scanner.nextLine());

        String message = "";

        for (int i = 1; i <= numChars; i++) {
            char currentChar = scanner.nextLine().charAt(0);

            currentChar += key;
            message += currentChar;
        }

        System.out.println(message);

    }
}
