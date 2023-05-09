package P18List_More_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String text = scanner.nextLine();
        String output = "";

        for (Integer currentElement : numbersList) {
            int charIndexInText = 0;
            while (currentElement > 0) {
                charIndexInText += currentElement % 10;
                currentElement /= 10;
            }
            charIndexInText = charIndexInText % text.length();
            char takenChar = text.charAt(charIndexInText);
            output += takenChar;
            String newText = "";
            for (int i = 0; i < text.length(); i++) {
                if (i != charIndexInText) {
                    newText += text.charAt(i);
                }
            }
            text = newText;
        }

        System.out.println(output);

    }

}
