package P28TextProcessing_Lab;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.nextLine();
        String largeString = scanner.nextLine();

        while (largeString.contains(firstString)) {
            largeString = largeString.replace(firstString, "");
        }

        System.out.println(largeString);

    }
}
