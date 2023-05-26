package P19ExamPreparation;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        boolean isOutOfEnergy = false;
        int wonBattlesCounter = 0;

        String command = scanner.nextLine();

        while (!command.equals("End of battle")) {
            int currentDistance = Integer.parseInt(command);
            if (initialEnergy - currentDistance >= 0) {
                initialEnergy -= currentDistance;
                wonBattlesCounter++;
                if (wonBattlesCounter % 3 == 0) {
                    initialEnergy += wonBattlesCounter;
                }
            } else {
                isOutOfEnergy = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isOutOfEnergy) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", wonBattlesCounter, initialEnergy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d%n", wonBattlesCounter, initialEnergy);
        }

    }
}
