package P25MapsLambdaAndStreamAPI;

import java.text.DecimalFormat;
import java.util.*;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> realNumbersTreeMap = new TreeMap<>();

        for (double num : numbersArr) {
            if (!realNumbersTreeMap.containsKey(num)) {
                realNumbersTreeMap.put(num, 1);
            } else {
                int value = realNumbersTreeMap.get(num);
                realNumbersTreeMap.put(num, value + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : realNumbersTreeMap.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
