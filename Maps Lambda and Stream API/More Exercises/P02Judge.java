package P26MapsLambdaAndStreamAPI_More_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> contestsAndUsersMap = new LinkedHashMap<>();

        while (!input.equals("no more time")) {
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            if (contestsAndUsersMap.containsKey(contest)) {
                if (contestsAndUsersMap.get(contest).containsKey(username)) {
                    if (points > contestsAndUsersMap.get(contest).get(username)) {
                        int pointsToAdd = points - contestsAndUsersMap.get(contest).get(username);
                        contestsAndUsersMap.get(contest).put(username, points);
                    }
                } else {
                    contestsAndUsersMap.get(contest).put(username, points);
                }
            } else {
                contestsAndUsersMap.put(contest, new LinkedHashMap<>());
                contestsAndUsersMap.get(contest).put(username, points);
            }

            input = scanner.nextLine();
        }



        for (Map.Entry<String, Map<String, Integer>> entry : contestsAndUsersMap.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            Map<String, Integer> orderedValuesAndUsers = new LinkedHashMap<>();
            entry.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey())).forEachOrdered(x -> orderedValuesAndUsers.put(x.getKey(), x.getValue()));
            int counter = 0;


            for (Map.Entry<String, Integer> item : orderedValuesAndUsers.entrySet()) {
                counter++;
                System.out.printf("%d. %s <::> %d%n", counter, item.getKey(), item.getValue());
            }
        }
        System.out.println("Individual standings:");

        Map<String, Integer> usersPointsMap = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : contestsAndUsersMap.entrySet()) {
            for (Map.Entry<String, Integer> item : entry.getValue().entrySet()) {
                usersPointsMap.putIfAbsent(item.getKey(), 0);
                usersPointsMap.put(item.getKey(), usersPointsMap.get(item.getKey()) + item.getValue());
            }
        }

        Map<String, Integer> orderedUsersAndPoints = new LinkedHashMap<>();
        usersPointsMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey())).forEachOrdered(x -> orderedUsersAndPoints.put(x.getKey(), x.getValue()));

        int counter = 0;
        for (Map.Entry<String, Integer> entry : orderedUsersAndPoints.entrySet()) {
            counter++;
            System.out.printf("%d. %s -> %d%n", counter, entry.getKey(), entry.getValue());
        }

    }
}
