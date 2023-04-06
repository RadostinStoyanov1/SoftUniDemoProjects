package P11Arrays;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        /*for (int i = inputArr.length - 1; i >= 0; i--) {
            System.out.print(inputArr[i] + " "); // Тук правим толкова итерации, колкото е дължината на масива
        }*/

        for (int i = 0; i <= (inputArr.length - 1) / 2; i++) {
            String currentChange = inputArr[i];
            inputArr[i] = inputArr[inputArr.length -1 - i];
            inputArr[inputArr.length - 1 - i] = currentChange;
        }

        System.out.println(String.join(" ", inputArr));

    }
}
