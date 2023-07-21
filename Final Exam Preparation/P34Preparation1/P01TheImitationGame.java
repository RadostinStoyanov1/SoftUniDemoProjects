package P34ExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder codedMessage = new StringBuilder(scanner.nextLine());

        String message = scanner.nextLine();

        while (!message.equals("Decode")) {
            List<String> command = Arrays.stream(message.split("\\|")).collect(Collectors.toList());
            String typeCommand = command.get(0);

            if (typeCommand.equals("Move")) {
                int num = Integer.parseInt(command.get(1));
                codedMessage = new StringBuilder(moveNSymbols(codedMessage, num));
            } else if (typeCommand.equals("Insert")) {
                int index = Integer.parseInt(command.get(1));
                String addText = command.get(2);
                codedMessage.insert(index, addText);
            } else if (typeCommand.equals("ChangeAll")) {
                String substring = command.get(1);
                String replacement = command.get(2);
                codedMessage = replaceAllChars(codedMessage, substring, replacement);
            }

            message = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s%n", codedMessage.toString());

    }

    public static StringBuilder moveNSymbols(StringBuilder codedMessage, int num) {
        for (int i = 0; i < num; i++) {
            char currentChar = codedMessage.charAt(0);
            codedMessage.replace(0, 1, "");
            codedMessage.append(currentChar);
        }
        return codedMessage;
    }

    public static StringBuilder replaceAllChars (StringBuilder codedMessage, String substring, String replacement) {
        String currentMessage = codedMessage.toString();
        currentMessage = currentMessage.replace(substring, replacement);
        codedMessage = new StringBuilder(currentMessage);
        return codedMessage;
    }

}
