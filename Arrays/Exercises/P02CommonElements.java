package P12Ararys_Exercises;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" ");

        String[] array2 = scanner.nextLine().split(" ");

        for (String s : array2) {
            for (String s1 : array1) {
                if (s1.equals(s)) {
                    System.out.print(s + " ");
                    break;
                }
            }
        }

    }
}
