package P14Methods;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputWidth = Integer.parseInt(scanner.nextLine());
        int inputLength = Integer.parseInt(scanner.nextLine());

        int area = calculateRectangleArea(inputWidth, inputLength);

        System.out.println(area);

    }

    public static int calculateRectangleArea(int width, int length) {
        return width * length;
    }

}
