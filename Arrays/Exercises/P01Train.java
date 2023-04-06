package P12Ararys_Exercises;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagonNumbers = Integer.parseInt(scanner.nextLine());

        int[] trainArr = new int[wagonNumbers];

        int sumPeople = 0;

        for (int i = 0; i < trainArr.length; i++) {
            trainArr[i] = Integer.parseInt(scanner.nextLine());
            sumPeople += trainArr[i];
        }

        int printCounter = 0;

        for (int i : trainArr) {
            if (printCounter == trainArr.length - 1) {
                System.out.println(i);
            } else {
                System.out.print(i + " ");
                printCounter++;
            }
        }

        System.out.println(sumPeople);

    }
}
