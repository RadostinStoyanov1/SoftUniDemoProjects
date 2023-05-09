package P17List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> output = sumNumbersInAList(input);

        for (Integer num : output) {
            String currentNum = "";
            currentNum += num;
            System.out.print(currentNum + " ");
        }

    }

    public static List<Integer> sumNumbersInAList (List<Integer> numbers) {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i <= (numbers.size() / 2) - 1; i++) {
            output.add(numbers.get(i) + numbers.get(numbers.size() - 1 - i));
        }

        if (numbers.size() % 2 != 0) {
            output.add(numbers.get((numbers.size() - 1) / 2));
        }

        return output;

    }

}
