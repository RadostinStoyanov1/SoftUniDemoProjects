package P12Ararys_Exercises;

import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStringArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputStringArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < inputIntArr.length - 1; i++) {
            for (int j = i + 1; j < inputIntArr.length; j++) {
                if ((inputIntArr[i] + inputIntArr[j]) == n) {
                    System.out.println(inputIntArr[i] + " " + inputIntArr[j]);
                }
            }
        }

    }
}
