package P20ExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PXXHeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighbourhood = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        int currentIndex = 0;

        while (!command.equals("Love!")) {
            int numToIncreaseIndex = Integer.parseInt(command.split(" ")[1]);
            currentIndex += numToIncreaseIndex;
            if (currentIndex > neighbourhood.size() - 1) {
                currentIndex = 0;
            }
            if (neighbourhood.get(currentIndex) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
                command = scanner.nextLine();
                continue;
            }
            neighbourhood.set(currentIndex, neighbourhood.get(currentIndex) - 2);
            if (neighbourhood.get(currentIndex) == 0) {
                System.out.printf("Place %d has Valentine's day.%n", currentIndex);
            }

            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", currentIndex);

        neighbourhood.removeAll(Arrays.asList(Integer.valueOf(0)));

        if (neighbourhood.isEmpty()) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", neighbourhood.size());
        }

    }
}
