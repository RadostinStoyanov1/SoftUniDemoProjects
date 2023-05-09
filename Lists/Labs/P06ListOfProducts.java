package P17List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> productList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            productList.add(scanner.nextLine());
        }

        Collections.sort(productList);

        for (int i = 1; i <= productList.size(); i++) {
            System.out.println(i + "." + productList.get(i - 1));
        }

    }
}
