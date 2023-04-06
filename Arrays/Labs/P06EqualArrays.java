package P11Arrays;

import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split(" ");
        int[] arrayInt1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            arrayInt1[i] = Integer.parseInt(input1[i]);
        }

        String[] input2 = scanner.nextLine().split(" ");
        int[] arrayInt2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            arrayInt2[i] = Integer.parseInt(input2[i]);
        }

        int sumArray1 = 0;
        boolean differentArrays = false;
        boolean differentLength = false;
        int minLength = -1;

        if (arrayInt1.length != arrayInt2.length) {
            differentLength = true;
            if (arrayInt1.length > arrayInt2.length) {
                minLength = arrayInt1.length - arrayInt2.length;
            } else {
                minLength = arrayInt2.length - arrayInt1.length;
            }
        }

        for (int i = 0; i < arrayInt1.length; i++) {
            if (arrayInt1[i] == arrayInt2[i]) {
                sumArray1 += arrayInt1[i];
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.%n", i);
                differentArrays = true;
                break;
            }
        }

        if (!differentArrays) {
            System.out.printf("Arrays are identical. Sum: %d%n", sumArray1);
        } else if (differentLength) {
            System.out.printf("Arrays are not identical. Found difference at %d index.%n", minLength);
        }


    }
}
