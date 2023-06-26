package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, ArrayList<String>> companiesMap = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            if (!companiesMap.containsKey(company)) {
                companiesMap.put(company, new ArrayList<>());
                companiesMap.get(company).add(employeeID);
            } else {
                if (!companiesMap.get(company).contains(employeeID)) {
                    companiesMap.get(company).add(employeeID);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : companiesMap.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n", entry.getValue().get(i));
            }
        }

    }
}
