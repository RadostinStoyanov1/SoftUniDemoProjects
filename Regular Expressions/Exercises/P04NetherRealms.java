package P32RegularExpressions_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P04NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demonsList = Arrays.stream(scanner.nextLine().split("\\s*,\\s*")).collect(Collectors.toList());
        String regexHealth = "[^0-9+\\-*/.]";
        Pattern patternHealth = Pattern.compile(regexHealth);
        String regexDamage = "\\+?-?\\d+\\.?\\d*";
        Pattern patternDamage = Pattern.compile(regexDamage);

        for (String name : demonsList) {
            int health = 0;
            double damage = 0;

            Matcher healthMatcher = patternHealth.matcher(name);
            while (healthMatcher.find()) {
                char currentChar = healthMatcher.group().charAt(0);
                health += currentChar;
            }

            Matcher damageMatcher = patternDamage.matcher(name);
            while (damageMatcher.find()) {
                double currentDamage = Double.parseDouble(damageMatcher.group());
                damage += currentDamage;
            }

            for (char c : name.toCharArray()) {
                if (c == '*') {
                    damage *= 2;
                } else if (c == '/') {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", name, health, damage);

        }

    }
}
