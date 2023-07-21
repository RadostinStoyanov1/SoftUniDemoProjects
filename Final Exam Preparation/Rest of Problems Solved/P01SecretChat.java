package P36FinalExamPreparation;

import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder codedMessage = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {

            String[] commandArr = command.split(":\\|:");
            String action = commandArr[0];
            boolean isError = false;

            if (action.equals("InsertSpace")) {
                int index = Integer.parseInt(commandArr[1]);
                codedMessage.insert(index, " ");

            } else if (action.equals("Reverse")) {
                String substring = commandArr[1];

                if (codedMessage.toString().contains(substring)) {

                    String reversedSubstring = new StringBuilder(substring).reverse().toString();

                    int firstIndex = codedMessage.indexOf(substring);
                    int lastIndex = firstIndex + substring.length();

                    codedMessage.replace(firstIndex, lastIndex, "");
                    codedMessage.append(reversedSubstring);

                } else {
                    isError = true;
                    System.out.println("error");
                }

            } else if (action.equals("ChangeAll")) {
                String substring = commandArr[1];
                String replacement = commandArr[2];
                String text = codedMessage.toString();
                text = text.replaceAll(substring, replacement);
                codedMessage = new StringBuilder(text);
            }

            if (!isError) {
                System.out.println(codedMessage);
            }

            command = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", codedMessage);

    }
}
