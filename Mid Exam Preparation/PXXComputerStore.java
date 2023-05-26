package P20ExamPreparation;

import java.util.Scanner;

public class PXXComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double totalPriceNoVAT = 0;

        while (!command.equals("special") && !command.equals("regular")) {
            double currentPrice = Double.parseDouble(command);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceNoVAT += currentPrice;
            }

            command = scanner.nextLine();
        }

        if (totalPriceNoVAT == 0) {
            System.out.println("Invalid order!");
        } else {
            double totalVAT = totalPriceNoVAT * 0.2;
            double totalPriceWithVAT = totalPriceNoVAT + totalVAT;
            if (command.equals("special")) {
                totalPriceWithVAT = 0.9 * totalPriceWithVAT;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPriceNoVAT);
            System.out.printf("Taxes: %.2f$%n", totalVAT);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPriceWithVAT);
        }

    }
}
