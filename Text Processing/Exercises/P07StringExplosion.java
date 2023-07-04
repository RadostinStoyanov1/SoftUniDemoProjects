package P29TextProcessing_Execise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int leftBombStrength = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '>') {
                int bombStrength = Character.getNumericValue(input.charAt(i + 1)) + leftBombStrength;
                leftBombStrength = 0;
                for (int j = i + 1; j <= i + bombStrength; j++) {
                    if (input.charAt(j) == '>') {
                        leftBombStrength = bombStrength;
                        break;
                    } else {
                        input.replace(j, j + 1, "");
                        bombStrength--;
                        j--;
                    }
                    if (j == input.length() - 1) {
                        break;
                    }
                }
            }
        }

        System.out.println(input);

    }
}
