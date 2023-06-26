package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();
        Map<String, Double> productsPrice = new LinkedHashMap<>();

        while (!data.equals("buy")) {
            String productName = data.split("\\s+")[0];
            double price = Double.parseDouble(data.split("\\s+")[1]);
            int quantity = Integer.parseInt(data.split("\\s+")[2]);

            if (!productsQuantity.containsKey(productName)) {
                productsQuantity.put(productName, quantity);
            } else {
                int previousQuantity = productsQuantity.get(productName);
                productsQuantity.put(productName, previousQuantity + quantity);
            }

            productsPrice.put(productName, price);

            data = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {
            double actualPrice = productsPrice.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue() * actualPrice);
        }

    }
}
