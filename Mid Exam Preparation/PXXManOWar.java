package P20ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class PXXManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHealth = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        boolean isWarShipSunk = false;
        boolean isPirateShipSunk = false;

        while (!command.equals("Retire")) {

            if (command.startsWith("Fire")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int power = Integer.parseInt(command.split(" ")[2]);
                if (index >= 0 && index < warShip.length) {
                    warShip[index] -= power;
                    if (warShip[index] <= 0) {
                        isWarShipSunk = true;
                        System.out.println("You won! The enemy ship has sunken.");
                        break;
                    }
                }
            } else if (command.startsWith("Defend")) {
                int startIndex = Integer.parseInt(command.split(" ")[1]);
                int endIndex = Integer.parseInt(command.split(" ")[2]);
                int attackPower = Integer.parseInt(command.split(" ")[3]);
                if (startIndex >= 0 && startIndex < pirateShip.length && endIndex >= 0 && endIndex < pirateShip.length) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip[i] -= attackPower;
                        if (pirateShip[i] <= 0) {
                            isPirateShipSunk = true;
                            System.out.println("You lost! The pirate ship has sunken.");
                            break;
                        }
                    }
                }
            } else if (command.startsWith("Repair")) {
                int repairIndex = Integer.parseInt(command.split(" ")[1]);
                int repairPower = Integer.parseInt(command.split(" ")[2]);
                if (repairIndex >= 0 && repairIndex < pirateShip.length) {
                    pirateShip[repairIndex] += repairPower;
                    if (pirateShip[repairIndex] > maxHealth) {
                        pirateShip[repairIndex] = maxHealth;
                    }
                }
            } else if (command.startsWith("Status")) {
                int numSectionsNeededRepair = 0;
                for (int i = 0; i < pirateShip.length; i++) {
                    if (pirateShip[i] < maxHealth * 0.2) {
                        numSectionsNeededRepair++;
                    }
                }
                System.out.printf("%d sections need repair.%n", numSectionsNeededRepair);
            }

            command = scanner.nextLine();
        }

        if (!isPirateShipSunk && !isWarShipSunk) {
            int pirateShipSum = 0;
            int warShipSum = 0;
            for (int i = 0; i < pirateShip.length; i++) {
                pirateShipSum += pirateShip[i];
            }
            for (int i = 0; i < warShip.length; i++) {
                warShipSum += warShip[i];
            }

            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d%n", warShipSum);

        }

    }
}
