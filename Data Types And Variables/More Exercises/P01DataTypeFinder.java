package P09dataTypesAndVariables_More_Exercises;

import java.util.Scanner;

public class P01DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            Scanner type = new Scanner(input);
            if (type.hasNextBoolean()) {
                System.out.printf("%s is boolean type%n", input);
            } else if (type.hasNextInt()) {
                System.out.printf("%s is integer type%n", input);
            } else if (type.hasNextFloat()) {
                System.out.printf("%s is floating point type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }



            input = scanner.nextLine();
        }

    }
}
