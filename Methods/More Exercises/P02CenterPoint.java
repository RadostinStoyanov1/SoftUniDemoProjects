package P15Methods_More_Exercises;

import java.util.Scanner;

public class P02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int point1X = Integer.parseInt(scanner.nextLine());
        int point1Y = Integer.parseInt(scanner.nextLine());
        int point2X = Integer.parseInt(scanner.nextLine());
        int point2Y = Integer.parseInt(scanner.nextLine());

        boolean isPoint1Closer = point1Closer(point1X, point1Y, point2X, point2Y);

        if (isPoint1Closer) {
            System.out.printf("(%d, %d)%n", point1X, point1Y);
        } else {
            System.out.printf("(%d, %d)%n", point2X, point2Y);
        }

    }

    public static boolean point1Closer (int point1X, int point1Y, int point2X, int point2Y) {
        point1X = Math.abs(point1X);
        point1Y = Math.abs(point1Y);
        point2X = Math.abs(point2X);
        point2Y = Math.abs(point2Y);
        return (Math.pow(point1X, 2) + Math.pow(point1Y, 2)) <= (Math.pow(point2X, 2) + Math.pow(point2Y, 2));
    }

}
