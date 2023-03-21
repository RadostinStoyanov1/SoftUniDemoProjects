package P09dataTypesAndVariables_More_Exercises;

import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numA = Double.parseDouble(scanner.nextLine());
        double numB = Double.parseDouble(scanner.nextLine());

        double higherNumber = Math.max(numA, numB);
        double lowerNumber = Math.min(numA, numB);

        double difference = Math.abs(higherNumber - lowerNumber);

        if (difference <= 0.000001) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
