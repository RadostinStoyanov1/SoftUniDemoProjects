package P12Ararys_Exercises;

import java.util.Scanner;

public class P03Zig_ZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int i = 1; i <= n; i++) {
            String[] currentStringArr = scanner.nextLine().split(" ");
            int[] currentIntArr = new int[currentStringArr.length];
            for (int j = 0; j < currentStringArr.length; j++) {
                currentIntArr[j] = Integer.parseInt(currentStringArr[j]);
            }

            if (i % 2 == 0) {
                firstArr[i - 1] = currentIntArr[1];
                secondArr[i - 1] = currentIntArr[0];
            } else {
                firstArr[i - 1] = currentIntArr[0];
                secondArr[i - 1] = currentIntArr[1];
            }
        }

        for (int i : firstArr) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : secondArr) {
            System.out.print(i + " ");
        }

    }
}
