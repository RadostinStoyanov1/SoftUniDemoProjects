package P20ExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int totalValue = 0;

        for (Integer number : numbers) {
            totalValue += number;
        }

        double averageValue = totalValue * 1.0 / numbers.size();

        numbers.removeIf(num -> num <= averageValue);

        if (numbers.isEmpty()) {
            System.out.println("No");
        } else {
            Collections.sort(numbers);
            Collections.reverse(numbers);
            while (numbers.size() > 5) {
                numbers.remove(numbers.size() - 1);
            }
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        }



    }
}
