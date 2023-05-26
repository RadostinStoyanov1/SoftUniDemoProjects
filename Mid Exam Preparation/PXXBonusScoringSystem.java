package P20ExamPreparation;

import java.util.Scanner;

public class PXXBonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());
        int numLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        int maxNumLectures = 0;
        double maxBonus = 0;

        for (int i = 1; i <= numStudents; i++) {
            int currentNumLectures = Integer.parseInt(scanner.nextLine());
            double currentBonus = (currentNumLectures * 1.0 / numLectures) * (5 + additionalBonus);
            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;
                maxNumLectures = currentNumLectures;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.%n", maxNumLectures);

    }
}
