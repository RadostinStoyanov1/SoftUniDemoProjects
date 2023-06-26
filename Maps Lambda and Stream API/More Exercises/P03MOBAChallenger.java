package P26MapsLambdaAndStreamAPI_More_Exercise;

import java.util.*;

public class P03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> playerPoolMap = new LinkedHashMap<>();

        while (!input.equals("Season end")) {


            if (input.contains(" -> ")) {
                String player = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skillPoints = Integer.parseInt(input.split(" -> ")[2]);

                if (!playerPoolMap.containsKey(player)) {
                    playerPoolMap.put(player, new LinkedHashMap<>());
                    playerPoolMap.get(player).put(position, skillPoints);
                } else {
                    if (!playerPoolMap.get(player).containsKey(position)) {
                        playerPoolMap.get(player).put(position, skillPoints);
                    } else {
                        if (skillPoints > playerPoolMap.get(player).get(position)) {
                            playerPoolMap.get(player).put(position, skillPoints);
                        }
                    }
                }
            } else if (input.contains(" vs ")) {
                String player1 = input.split(" vs ")[0];
                String player2 = input.split(" vs ")[1];
                if (playerPoolMap.containsKey(player1) && playerPoolMap.containsKey(player2)) {

                    for (Map.Entry<String, Integer> firstPlayerPositions : playerPoolMap.get(player1).entrySet()) {
                        for (Map.Entry<String, Integer> secondPlayerPositions : playerPoolMap.get(player2).entrySet()) {
                            if (firstPlayerPositions.getKey().equals(secondPlayerPositions.getKey())) {
                                int firstPLayerPoints = playerPoolMap.get(player1).values().stream().mapToInt(integer -> integer).sum();
                                int secondPlayerPoints = playerPoolMap.get(player2).values().stream().mapToInt(Integer::intValue).sum();

                                if (firstPLayerPoints > secondPlayerPoints) {
                                    playerPoolMap.remove(player2);
                                } else if (firstPLayerPoints < secondPlayerPoints) {
                                    playerPoolMap.remove(player1);
                                }

                            }
                        }
                    }

                }
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> playersTotalPointsMap = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : playerPoolMap.entrySet()) {
            int totalPoints = entry.getValue().values().stream().mapToInt(integer -> integer).sum();
            playersTotalPointsMap.put(entry.getKey(), totalPoints);
        }

        Map<String, Integer> playersTotalPointsMapOrdered = new LinkedHashMap<>();

        playersTotalPointsMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEachOrdered(k -> playersTotalPointsMapOrdered.put(k.getKey(), k.getValue()));

        for (Map.Entry<String, Integer> entry : playersTotalPointsMapOrdered.entrySet()) {
            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue());

            for (Map.Entry<String, Map<String, Integer>> item : playerPoolMap.entrySet()) {
                Map<String, Integer> sortedMap = new LinkedHashMap<>();

                if (entry.getKey().equals(item.getKey())) {
                    item.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                            .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

                    for (Map.Entry<String, Integer> element : sortedMap.entrySet()) {
                        System.out.printf("- %s <::> %d%n", element.getKey(), element.getValue());
                    }
                }


            }

        }

    }
}
