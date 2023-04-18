package P14Methods;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int productQuantity = Integer.parseInt(scanner.nextLine());

        printBill(product, productQuantity);

    }

    public static void printBill(String product, int quantity) {
        double totalAmount = 0;
        switch (product) {
            case "coffee":
                totalAmount = 1.50 * quantity;
                break;
            case "water":
                totalAmount = 1.00 * quantity;
                break;
            case "coke":
                totalAmount = 1.40 * quantity;
                break;
            case "snacks":
                totalAmount = 2.00 * quantity;
        }

        System.out.printf("%.2f%n", totalAmount);

    }

}
