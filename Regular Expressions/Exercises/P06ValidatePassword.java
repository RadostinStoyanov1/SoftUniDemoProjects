package P32RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regexPass = "\\b_\\.+[A-Z][A-Za-z0-9]{4,}[A-Z]_\\.+";
        Pattern patternPass = Pattern.compile(regexPass);

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            Matcher passMatcher = patternPass.matcher(input);
            if (passMatcher.find()) {
                StringBuilder digits = new StringBuilder();
                String digitRegex = "[0-9]+";
                Pattern patternDigit = Pattern.compile(digitRegex);
                Matcher digitMatcher = patternDigit.matcher(input);
                while (digitMatcher.find()) {
                    digits.append(digitMatcher.group());
                }
                if (digits.length() > 0) {
                    System.out.printf("Group: %s%n", digits);
                } else if (digits.length() == 0){
                    System.out.println("Group: default");
                }
            } else {
                System.out.println("Invalid pass!");
            }
        }

    }
}
