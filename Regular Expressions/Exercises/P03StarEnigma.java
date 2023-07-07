package P32RegularExpressions_Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planet>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackDestroy>[A-Z])![^@!:>-]*->(?<numSoldiers>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            String originalMessage = scanner.nextLine();
            String decryptedMessage = decryptMessage(originalMessage);

            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String currentPlanet = matcher.group("planet");
                String attackDestroy = matcher.group("attackDestroy");

                if (attackDestroy.equals("A")) {
                    attackedPlanets.add(currentPlanet);
                } else if (attackDestroy.equals("D")) {
                    destroyedPlanets.add(currentPlanet);
                }
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        attackedPlanets.forEach(planet -> System.out.println("-> " + planet));

        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));

    }

    public static String decryptMessage(String originalMessage) {
        int decryptionKey = findKey(originalMessage);
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : originalMessage.toCharArray()) {
            char newSymbol = (char)(c - decryptionKey);
            decryptedMessage.append(newSymbol);
        }

        return decryptedMessage.toString();

    }

    public static int findKey(String originalMessage) {
        int key = 0;

        for (char c : originalMessage.toCharArray()) {
            if (c == 'S' || c == 's' || c == 'T' || c == 't' || c == 'A' || c == 'a' || c == 'R' || c == 'r') {
                key++;
            }
        }

        return key;
    }

}
