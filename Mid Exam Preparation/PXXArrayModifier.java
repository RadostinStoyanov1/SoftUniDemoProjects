package P20ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class PXXArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandArr = command.split("\\s+");

            switch (commandArr[0]) {
                case "swap":
                    numbersArr = swapIndexes(numbersArr, commandArr);
                    break;
                case "multiply":
                    numbersArr = multiplyIndexes(numbersArr, commandArr);
                    break;
                case "decrease":
                    numbersArr = decreaseAllElements(numbersArr);
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbersArr).replace("[", "").replace("]", ""));


    }

    public static int[] swapIndexes(int[] numbersArr, String[] commandArr) {
        int index1 = Integer.parseInt(commandArr[1]);
        int index2 = Integer.parseInt(commandArr[2]);
        int currentElement = numbersArr[index1];
        numbersArr[index1] = numbersArr[index2];
        numbersArr[index2] = currentElement;
        return numbersArr;
    }

    public static int[] multiplyIndexes(int[] numbersArr, String[] commandArr) {
        int index1 = Integer.parseInt(commandArr[1]);
        int index2 = Integer.parseInt(commandArr[2]);
        int multipliedElement = numbersArr[index1] * numbersArr[index2];
        numbersArr[index1] = multipliedElement;
        return numbersArr;
    }

    public static int[] decreaseAllElements(int[] numbersArr) {
        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i] -= 1;
        }
        return numbersArr;
    }

}
