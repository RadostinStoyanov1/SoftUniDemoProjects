package P36FinalExamPreparation;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            boolean isSubstitute = true;
            if (command.startsWith("TakeOd")) {
                password = new StringBuilder(getOddPositionChars(password).toString());
            } else if (command.startsWith("Cut")) {
                int index = Integer.parseInt(command.split("\\s+")[1]);
                int length = Integer.parseInt(command.split("\\s+")[2]);
                int endIndex = index + length;
                password.replace(index, endIndex, "");
            } else if (command.startsWith("Substitute")) {
                String substring = command.split("\\s+")[1];
                String substitute = command.split("\\s+")[2];

                if (password.toString().contains(substring)) {
                    String currentText = password.toString();
                    currentText = currentText.replace(substring, substitute);
                    password = new StringBuilder(currentText);
                } else {
                    isSubstitute = false;
                    System.out.println("Nothing to replace!");
                }
            }

            if (isSubstitute) {
                System.out.println(password);
            }

            command = scanner.nextLine();

        }

        System.out.printf("Your password is: %s%n", password);

    }

    public static StringBuilder getOddPositionChars(StringBuilder password) {
        StringBuilder newPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                newPassword.append(password.charAt(i));
            }
        }
        return newPassword;
    }

}
