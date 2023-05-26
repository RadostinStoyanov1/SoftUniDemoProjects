package P20ExamPreparation;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numDays = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedFinalPlunder = Integer.parseInt(scanner.nextLine());
        double totalPlunder = 0;

        for (int i = 1; i <= numDays; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder += dailyPlunder * 0.5;
            }

            if (i % 5 == 0) {
                totalPlunder *= 0.7;
            }
        }

        if (totalPlunder >= expectedFinalPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", totalPlunder);
        } else {
            double percentGathered = (totalPlunder / expectedFinalPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentGathered);
        }

    }
}
