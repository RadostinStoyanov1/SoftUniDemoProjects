package P20ExamPreparation;

import java.util.Scanner;

public class PXXMuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoin = 0;

        String[] rooms = scanner.nextLine().split("\\|");
        boolean isDead = false;

        for (int i = 0; i < rooms.length; i++) {
            String command = rooms[i];

            if (command.startsWith("potion")) {
                int potionPower = Integer.parseInt(command.split("\\s+")[1]);
                if (health + potionPower > 100) {
                    potionPower = 100 - health;
                }
                health += potionPower;
                System.out.printf("You healed for %d hp.%n", potionPower);
                System.out.printf("Current health: %d hp.%n", health);
            } else if (command.startsWith("chest")) {
                int foundBitcoins = Integer.parseInt(command.split("\\s+")[1]);
                bitcoin += foundBitcoins;
                System.out.printf("You found %d bitcoins.%n", foundBitcoins);
            } else {
                int attackPower = Integer.parseInt(command.split("\\s+")[1]);
                String monsterName = command.split("\\s+")[0];
                health -= attackPower;
                if (health > 0) {
                    System.out.printf("You slayed %s.%n", monsterName);
                } else {
                    System.out.printf("You died! Killed by %s.%n", monsterName);
                    System.out.printf("Best room: %d%n", i + 1);
                    isDead = true;
                    break;
                }
            }

        }

        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoin);
            System.out.printf("Health: %d%n", health);
        }

    }
}
