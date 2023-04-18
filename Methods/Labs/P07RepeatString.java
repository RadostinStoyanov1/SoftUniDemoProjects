package P14Methods;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeatTimes = Integer.parseInt(scanner.nextLine());

        String printOutput = getNTimesString(input, repeatTimes);

        System.out.println(printOutput);

    }


    public static String getNTimesString (String input, int n) {
        String output = "";
        for (int i = 1; i <= n; i++) {
            output += input;
        }
        return output;
    }
}
