package P36FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "(=|/)(?<destination>[A-Z][A-z]{2,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int tripPoints = 0;
        List<String> destinationsList = new ArrayList<>();

        while (matcher.find()) {
            String currentDestination = matcher.group("destination");
            tripPoints += currentDestination.length();
            destinationsList.add(currentDestination);
        }

        System.out.printf("Destinations: %s%n", String.join(", ", destinationsList));
        System.out.printf("Travel Points: %d%n", tripPoints);
    }
}
