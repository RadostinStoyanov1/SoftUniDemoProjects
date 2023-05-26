package P20ExamPreparation;

import java.util.Scanner;

public class PXXSoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeCapacity = Integer.parseInt(scanner.nextLine());
        int secondEmployeeCapacity = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeCapacity = Integer.parseInt(scanner.nextLine());
        int totalServedStudentsPerHour = firstEmployeeCapacity + secondEmployeeCapacity + thirdEmployeeCapacity;
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int hoursCounter = 0;

        while (studentsCount > 0) {
            hoursCounter++;

            if (hoursCounter % 4 == 0) {
                continue;
            }

            studentsCount -= totalServedStudentsPerHour;

        }

        System.out.printf("Time needed: %dh.%n", hoursCounter);

    }
}
