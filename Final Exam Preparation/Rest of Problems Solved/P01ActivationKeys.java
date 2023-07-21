package P36FinalExamPreparation;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder initialKey = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] commandArr = command.split(">>>");

            switch (commandArr[0]) {
                case "Contains":
                    String substring = commandArr[1];
                    if (initialKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", initialKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    int startIndex = Integer.parseInt(commandArr[2]);
                    int endIndex = Integer.parseInt(commandArr[3]);
                    String newSubstring = initialKey.substring(startIndex, endIndex);
                    if (commandArr[1].equals("Upper")) {
                        newSubstring = newSubstring.toUpperCase();
                        initialKey.replace(startIndex, endIndex, newSubstring);
                    } else if (commandArr[1].equals("Lower")) {
                        newSubstring = newSubstring.toLowerCase();
                        initialKey.replace(startIndex, endIndex, newSubstring);
                    }
                    System.out.println(initialKey);
                    break;

                case "Slice":
                    int firstIndex = Integer.parseInt(commandArr[1]);
                    int secondIndex = Integer.parseInt(commandArr[2]);
                    initialKey.replace(firstIndex, secondIndex, "");
                    System.out.println(initialKey);

            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s%n", initialKey);

    }
}
