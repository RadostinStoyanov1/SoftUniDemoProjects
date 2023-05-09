package P18List_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numSequence = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String bombNumAndPower = scanner.nextLine();
        int bombNumber = Integer.parseInt(bombNumAndPower.split("\\s+")[0]);
        int bombPower = Integer.parseInt(bombNumAndPower.split("\\s+")[1]);

        while (numSequence.contains(bombNumber)) {
            int index = numSequence.indexOf(bombNumber);
            int leftStartIndex = Math.max(0, index - bombPower);
            int rightStopIndex = Math.min(index + bombPower, numSequence.size() - 1);

            for (int i = rightStopIndex; i >= leftStartIndex; i--) {
                numSequence.remove(i);
            }
        }

        int sum = 0;
        for (Integer num : numSequence) {
            sum += num;
        }

        System.out.println(sum);

    }
}
