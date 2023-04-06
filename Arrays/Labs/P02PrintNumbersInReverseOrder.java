package P11Arrays;

import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersAmount = Integer.parseInt(scanner.nextLine());
        int[] currentArr = new int[numbersAmount];

        for (int i = 0; i < currentArr.length; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            currentArr[i] = currentNum;
        }

        for (int i = currentArr.length - 1; i >= 0; i--) {
            System.out.print(currentArr[i] + " ");
        }

    }
}
