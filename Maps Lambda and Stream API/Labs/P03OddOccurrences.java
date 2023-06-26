package P25MapsLambdaAndStreamAPI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> wordsMap = new LinkedHashMap<>();

        for (String element : inputArr) {
            element = element.toLowerCase();

            if (!wordsMap.containsKey(element)) {
                wordsMap.put(element, 1);
            } else {
                wordsMap.put(element, wordsMap.get(element) + 1);
            }
        }

        ArrayList<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", oddWords));

    }
}
