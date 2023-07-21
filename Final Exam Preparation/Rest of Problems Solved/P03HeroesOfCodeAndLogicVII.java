package P36FinalExamPreparation;

import java.util.*;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int heroesNumber = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();

        for (int i = 1; i <= heroesNumber; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int hitPoints = Integer.parseInt(input.split(" ")[1]);

            if (hitPoints > 100) {
                hitPoints = 100;
            }

            int manaPoints = Integer.parseInt(input.split(" ")[2]);

            if (manaPoints > 200) {
                manaPoints = 200;
            }

            if (heroesMap.containsKey(name)) {
                heroesMap.get(name).set(0, hitPoints);
                heroesMap.get(name).set(0, manaPoints);
            } else {
                heroesMap.put(name, new ArrayList<>());
                heroesMap.get(name).add(hitPoints);
                heroesMap.get(name).add(manaPoints);
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" - ");

            if (commandArr[0].equals("CastSpell")) {
                String heroName = commandArr[1];
                int mpNeeded = Integer.parseInt(commandArr[2]);
                String spellName = commandArr[3];

                if (heroesMap.get(heroName).get(1) >= mpNeeded) {
                    heroesMap.get(heroName).set(1, heroesMap.get(heroName).get(1) - mpNeeded);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroesMap.get(heroName).get(1));
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }
            } else if (commandArr[0].equals("TakeDamage")) {
                String heroName = commandArr[1];
                int damage = Integer.parseInt(commandArr[2]);
                String attacker = commandArr[3];

                if (heroesMap.get(heroName).get(0) > damage) {
                    heroesMap.get(heroName).set(0, heroesMap.get(heroName).get(0) - damage);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroesMap.get(heroName).get(0));
                } else {
                    heroesMap.remove(heroName);
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                }
            } else if (commandArr[0].equals("Recharge")) {
                String heroName = commandArr[1];
                int amount = Integer.parseInt(commandArr[2]);

                if (amount + heroesMap.get(heroName).get(1) > 200) {
                    amount = 200 - heroesMap.get(heroName).get(1);
                }

                heroesMap.get(heroName).set(1, heroesMap.get(heroName).get(1) + amount);
                System.out.printf("%s recharged for %d MP!%n", heroName, amount);
            } else if (commandArr[0].equals("Heal")) {
                String heroName = commandArr[1];
                int amount = Integer.parseInt(commandArr[2]);

                if (amount + heroesMap.get(heroName).get(0) > 100) {
                    amount = 100 - heroesMap.get(heroName).get(0);
                }

                heroesMap.get(heroName).set(0, heroesMap.get(heroName).get(0) + amount);
                System.out.printf("%s healed for %d HP!%n", heroName, amount);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : heroesMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf("  HP: %d%n", entry.getValue().get(0));
            System.out.printf("  MP: %d%n", entry.getValue().get(1));
        }

    }
}
