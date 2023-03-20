package P06BasicSyntaxConditionalStatementsAndLoops_More_Exercizes;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double currentBalance = budget;
        boolean isOutOfMoney = false;

        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {
            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (currentBalance >= 39.99) {
                        currentBalance -= 39.99;
                        System.out.printf("Bought %s%n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if (currentBalance >= 15.99) {
                        currentBalance -= 15.99;
                        System.out.printf("Bought %s%n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    if (currentBalance >= 19.99) {
                        currentBalance -= 19.99;
                        System.out.printf("Bought %s%n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if (currentBalance >= 59.99) {
                        currentBalance -= 59.99;
                        System.out.printf("Bought %s%n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if (currentBalance >= 29.99) {
                        currentBalance -= 29.99;
                        System.out.printf("Bought %s%n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
            }

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                isOutOfMoney = true;
                break;
            }

            input = scanner.nextLine();
        }

        if (!isOutOfMoney) {
            double spentAmount = budget - currentBalance;
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f%n", spentAmount, currentBalance);
        }

    }
}
