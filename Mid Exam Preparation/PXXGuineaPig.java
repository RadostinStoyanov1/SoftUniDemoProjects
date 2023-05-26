package P20ExamPreparation;

import java.util.Scanner;

public class PXXGuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double pigsWeight = Double.parseDouble(scanner.nextLine()) * 1000;

        boolean isFinishedFood = false;

        for (int i = 1; i <= 30; i++) {
            foodQuantity -= 300;

            if (i % 2 == 0) {
                hayQuantity -= 0.05 * foodQuantity;
            }

            if (i % 3 == 0) {
                coverQuantity -= pigsWeight / 3;
            }

            if (foodQuantity <= 0 || hayQuantity <= 0 || coverQuantity <= 0) {
                isFinishedFood = true;
                break;
            }

        }

        foodQuantity /= 1000;
        hayQuantity /= 1000;
        coverQuantity /= 1000;

        if (isFinishedFood) {
            System.out.println("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n", foodQuantity, hayQuantity, coverQuantity);
        }

    }
}
