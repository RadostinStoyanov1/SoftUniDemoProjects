package P36FinalExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(@#+)(?<barcode>[A-Z][A-Za-z|0-9]{4,}[A-Z])(@#+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String barcode = matcher.group("barcode");
                StringBuilder barcodeGroup = new StringBuilder();
                for (int j = 0; j < barcode.length(); j++) {
                    if (Character.isDigit(barcode.charAt(j))) {
                        barcodeGroup.append(barcode.charAt(j));
                    }
                }

                if (barcodeGroup.length() == 0) {
                    barcodeGroup = new StringBuilder("00");
                }

                System.out.printf("Product group: %s%n", barcodeGroup);

            } else {
                System.out.println("Invalid barcode");
            }


        }

    }
}
