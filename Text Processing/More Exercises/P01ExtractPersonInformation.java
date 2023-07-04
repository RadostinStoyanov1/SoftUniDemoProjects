package P29TextProcessing_More_Exercise;

import java.util.Scanner;

public class P01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numLines; i++) {
            String currentText = scanner.nextLine();
            String name = currentText.substring(currentText.indexOf("@") + 1, currentText.indexOf("|"));
            String age = currentText.substring(currentText.indexOf("#") + 1, currentText.indexOf("*"));

            System.out.printf("%s is %s years old.%n", name, age);
        }

    }
}
