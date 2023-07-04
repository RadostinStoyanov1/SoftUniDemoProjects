package P29TextProcessing_Execise;

import java.math.BigInteger;
import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger(scanner.nextLine());
        int secondNumber =Integer.parseInt(scanner.nextLine());

        System.out.println(firstNumber.multiply(new BigInteger("" + secondNumber)));

    }
}
