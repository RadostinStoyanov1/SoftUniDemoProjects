package P06BasicSyntaxConditionalStatementsAndLoops_More_Exercizes;

import java.util.Scanner;

public class P04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();

        String outputString = "";
        int stringLength = inputString.length();

        for (int i = stringLength - 1; i >= 0; i--) {
            outputString += inputString.charAt(i);
        }

        System.out.println(outputString);

    }
}
