package P11Arrays;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dayNumber = Integer.parseInt(scanner.nextLine());

        String[] daysOfWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        if (dayNumber > 0 && dayNumber < 8) {
            System.out.println(daysOfWeek[dayNumber - 1]);
        } else {
            System.out.println("Invalid day!");
        }

    }
}
