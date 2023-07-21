package P36FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int totalCalories = 0;

        String regex = "(\\||#)(?<foodName>[A-z\\s+]+)(\\1)(?<expirationDate>\\d{2}/\\d{2}/\\d{2})(\\1)(?<calories>\\d{1,5})(\\1)";
        /*String regex = "(?<repeat>[\\|\\#]{1})(?<foodName>[A-z\\s+]+)\\1(?<expirationDate>[0-9]{2}[\\/]{1}[0-9]{2}[\\/]{1}[0-9]{2})\\1(?<calories>\\d{1,5})\\1";*/
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> foodList = new ArrayList<>();

        while (matcher.find()) {
            String foodName = matcher.group("foodName");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));

            totalCalories += calories;
            String currentFood = "Item: " + foodName + ", Best before: " + expirationDate + ", Nutrition: " + calories;
            foodList.add(currentFood);
        }

        int days = totalCalories / 2000;

        System.out.printf("You have food to last you for: %d days!%n", days);

        for (String s : foodList) {
            System.out.println(s);
        }

    }
}
