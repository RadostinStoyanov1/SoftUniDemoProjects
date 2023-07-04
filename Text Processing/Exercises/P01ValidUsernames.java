package P29TextProcessing_Execise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNames = scanner.nextLine().split(", ");

        for (int i = 0; i < inputNames.length; i++) {
            String  currentName = inputNames[i];
            boolean isValid = true;
            if (currentName.length() >= 3 && currentName.length() <= 16) {
                for (int j = 0; j < currentName.length(); j++) {
                    if (currentName.charAt(j) == 45 || currentName.charAt(j) == 95 || Character.isLetter(currentName.charAt(j)) || Character.isDigit(currentName.charAt(j))) {
                        isValid = true;
                        continue;
                    } else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    System.out.println(currentName);
                }
            }

        }

    }
}
