package P15Methods_More_Exercises;

import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        int y3 = Integer.parseInt(scanner.nextLine());
        int x4 = Integer.parseInt(scanner.nextLine());
        int y4 = Integer.parseInt(scanner.nextLine());

        int legOfXDirectionForLine1 = legOfTriangle(x1, x2);
        int legOfYDirectionForLine1 = legOfTriangle(y1, y2);

        double line1Length = lineLength(legOfXDirectionForLine1, legOfYDirectionForLine1);

        int legOfXDirectionForLine2 = legOfTriangle(x3, x4);
        int legOfYDirectionForLine2 = legOfTriangle(y3, y4);

        double line2Length = lineLength(legOfXDirectionForLine2, legOfYDirectionForLine2);

        if (line1Length >= line2Length) {
            boolean isPoint1Closer = point1Closer(x1, y1, x2, y2); //Проверка коя точка на линия 1 е по-близо до 0.
            if (isPoint1Closer) {
                System.out.printf("(%d, %d)", x1, y1);
                System.out.printf("(%d, %d)%n", x2, y2);
            } else {
                System.out.printf("(%d, %d)", x2, y2);
                System.out.printf("(%d, %d)%n", x1, y1);
            }
        } else {
            boolean isPoint3Closer = point1Closer(x3, y3, x4, y4);
            if (isPoint3Closer) {
                System.out.printf("(%d, %d)", x3, y3);
                System.out.printf("(%d, %d)%n", x4, y4);
            } else {
                System.out.printf("(%d, %d)", x4, y4);
                System.out.printf("(%d, %d)%n", x3, y3);
            }
        }

    }

    public static int legOfTriangle (int x1, int x2) {
        int legOfTriangle = 0;
        if ((x1 < 0 && x2 < 0) || (x1 > 0 && x2 > 0)) {
            legOfTriangle = Math.abs(x1 - x2);
        } else if ((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) {
            legOfTriangle = Math.abs(x1) + Math.abs(x2);
        } else if (x1 == 0) {
            legOfTriangle = Math.abs(x2);
        } else if (x2 == 0) {
            legOfTriangle = Math.abs(x1);
        }
        return legOfTriangle;
    }

    public static double lineLength (int leg1, int leg2) {
        double lineLength = Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
        return lineLength;
    }

    public static boolean point1Closer (int x1, int y1, int x2, int y2) {
        x1 = Math.abs(x1);
        y1 = Math.abs(y1);
        x2 = Math.abs(x2);
        y2 = Math.abs(y2);
        return (Math.pow(x1, 2) + Math.pow(y1, 2)) <= (Math.pow(x2, 2) + Math.pow(y2, 2));
    }

}
