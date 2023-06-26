package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> countCharsMap = new LinkedHashMap<>();

        for (char symbol : text.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            if(countCharsMap.containsKey(symbol)) {
                int currentCount = countCharsMap.get(symbol);
                countCharsMap.put(symbol,currentCount + 1);
            } else {
                countCharsMap.put(symbol, 1);
            }
        }

        countCharsMap.forEach((key, value)-> System.out.println(key + " -> " + value));

    }
}
