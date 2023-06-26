package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> userAndScore = new LinkedHashMap<>();
        Map<String, Integer> languageAndSubmissions = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String username = input.split("-")[0];
            if (input.contains("banned")) {
                userAndScore.remove(username);
            } else {
                String language = input.split("-")[1];
                int score = Integer.parseInt(input.split("-")[2]);

                if (languageAndSubmissions.containsKey(language)) {
                    languageAndSubmissions.put(language, languageAndSubmissions.get(language) + 1);
                } else {
                    languageAndSubmissions.put(language, 1);
                }

                if (userAndScore.containsKey(username)) {
                    if (score > userAndScore.get(username)) {
                        userAndScore.put(username, score);
                    }
                } else {
                    userAndScore.put(username, score);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : userAndScore.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languageAndSubmissions.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
