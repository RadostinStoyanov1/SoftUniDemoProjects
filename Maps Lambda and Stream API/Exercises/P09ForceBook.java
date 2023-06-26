package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, ArrayList<String>> teamsMap = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                //"{force_side} | {force_user}"
                String team = input.split(" \\| ")[0];
                String player = input.split(" \\| ")[1];

                if (!teamsMap.containsKey(team)) {
                    teamsMap.put(team, new ArrayList<>());

                }

                boolean existInOtherTeam = false;
                for (ArrayList<String> value : teamsMap.values()) {
                    if (value.contains(player)) {
                        existInOtherTeam = true;
                    }
                }

                if (!existInOtherTeam) {
                    teamsMap.get(team).add(player);
                }

            } else if (input.contains("->")) {
                //"{force_user} -> {force_side}"
                String player = input.split(" -> ")[0];
                String team = input.split(" -> ")[1];

                teamsMap.entrySet().forEach(entry -> entry.getValue().remove(player));

                if (teamsMap.containsKey(team)) {
                    List<String> currentPlayers = teamsMap.get(team);
                    currentPlayers.add(player); //промяната в единия списък, води до промяна и в другия списък (списъка в MAP-a)
                } else {
                    teamsMap.put(team, new ArrayList<>());
                    teamsMap.get(team).add(player);
                }

                System.out.printf("%s joins the %s side!%n", player, team);

            }


            input = scanner.nextLine();
        }

        teamsMap.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
            .forEach(entry -> {
            System.out.println("Side: " + entry.getKey() + ", Members: " + entry.getValue().size());
            entry.getValue().forEach(player -> System.out.println("! " + player));
        });

    }
}
