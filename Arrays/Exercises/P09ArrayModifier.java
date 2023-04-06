package P12Ararys_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStringArr = scanner.nextLine().split(" ");
        int[] inputIntArr = new int[inputStringArr.length];
        for (int i = 0; i < inputIntArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputStringArr[i]);
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] readingCommandArr = command.split(" ");

            if (readingCommandArr[0].equals("swap")) {
                int newIndex1 = Integer.parseInt(readingCommandArr[1]);
                int newIndex2 = Integer.parseInt(readingCommandArr[2]);
                int tempNum = inputIntArr[newIndex1];
                inputIntArr[newIndex1] = inputIntArr[newIndex2];
                inputIntArr[newIndex2] = tempNum;
            } else if (readingCommandArr[0].equals("multiply")) {
                int newIndex1 = Integer.parseInt(readingCommandArr[1]);
                int newIndex2 = Integer.parseInt(readingCommandArr[2]);
                inputIntArr[newIndex1] = inputIntArr[newIndex1] * inputIntArr[newIndex2];
            } else if (readingCommandArr[0].equals("decrease")) {
                for (int i = 0; i < inputIntArr.length; i++) {
                    inputIntArr[i] -= 1;
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(inputIntArr).replace("[", "").replace("]", ""));

        /*String[] output = new String[inputIntArr.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = "" + inputIntArr[i];
        }

        System.out.println(String.join(", ", output));*/

    }
}
