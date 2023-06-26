package P26MapsLambdaAndStreamAPI_More_Exercise;

import java.util.*;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> contestsAndPassMap = new LinkedHashMap<>();

        while (!input.equals("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestsAndPassMap.put(contest, password);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        Map<String, Map<String, Integer>> userContestMap = new TreeMap<>();

        while (!input.equals("end of submissions")) {
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            if (contestsAndPassMap.containsKey(contest) && contestsAndPassMap.get(contest).equals(password)) { //валиден контест и парола
                if (userContestMap.containsKey(username)) { //ако има такъв потребител:
                    if (userContestMap.get(username).containsKey(contest)) { //ако има вече такъв contest?
                        if (points > userContestMap.get(username).get(contest)) {
                            userContestMap.get(username).put(contest, points);
                        }
                    } else { //ако няма такъв contest:
                        userContestMap.get(username).put(contest, points);
                    }
                } else { // ако няма такъв потребител:
                    userContestMap.put(username, new LinkedHashMap<>());
                    userContestMap.get(username).put(contest, points);
                }
            }

            input = scanner.nextLine();
        }

        String bestUser = "";
        int bestScore = 0;

        for (Map.Entry<String, Map<String, Integer>> entry : userContestMap.entrySet()) {
            int currentPoints = 0;
            for (Map.Entry<String, Integer> item : entry.getValue().entrySet()) {
                currentPoints += item.getValue();
            }
            if (currentPoints > bestScore) {
                bestScore = currentPoints;
                bestUser = entry.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestUser, bestScore);
        System.out.println("Ranking:");

        for (Map.Entry<String, Map<String, Integer>> entry : userContestMap.entrySet()) {
            System.out.println(entry.getKey());

            Map<String, Integer> reverseSortedMap = new LinkedHashMap<>();
            entry.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
            for (Map.Entry<String, Integer> item : reverseSortedMap.entrySet()) {
                System.out.printf("#  %s -> %d%n", item.getKey(), item.getValue());
            }
            
        }

    }
}
