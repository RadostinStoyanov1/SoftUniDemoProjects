package P18List_Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] arrayWithStrings = input.split("\\|");
        List<String> listWithStrings = new ArrayList<>();

        for (int i = 0; i <= arrayWithStrings.length - 1; i++) {
            listWithStrings.add(arrayWithStrings[i]);
        }

        Collections.reverse(listWithStrings);

        String output = listWithStrings.toString().replace("[", "").replace("]", "").trim().replaceAll(",", "").replaceAll("\\s+", " ");
        System.out.println(output);

    }
}
