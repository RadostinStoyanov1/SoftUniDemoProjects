package P20ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02TheLiftSecondWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < wagons.length; i++) {
            if (peopleWaiting > 0) {
                int currentCountPeople = wagons[i];
                while (currentCountPeople < 4) {

                    if (peopleWaiting <= 0) {
                        break;
                    }
                    currentCountPeople++;
                    wagons[i] = currentCountPeople;
                    peopleWaiting--;
                }
            } else {
                break;
            }
        }

        if (peopleWaiting <= 0 && wagons[wagons.length - 1] < 4) {
            System.out.println("The lift has empty spots!");
        } else if (peopleWaiting > 0 && wagons[wagons.length - 1] >= 4) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

    }
}
