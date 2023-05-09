package P18List_More_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        List<Integer> drumsInitialQualityList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        List<Integer> drumCurrentQualityList = new ArrayList<>();
        for (int i = 0; i < drumsInitialQualityList.size(); i++) {
            drumCurrentQualityList.add(drumsInitialQualityList.get(i));
        }


        while (!command.equals("Hit it again, Gabsy!")) {
            int currentDayPower = Integer.parseInt(command);
            for (int i = 0; i < drumCurrentQualityList.size(); i++) {
                drumCurrentQualityList.set(i, drumCurrentQualityList.get(i) - currentDayPower);
                if (drumCurrentQualityList.get(i) <= 0) {
                    if (budget >= drumsInitialQualityList.get(i) * 3) {
                        budget -= drumsInitialQualityList.get(i) * 3;
                        drumCurrentQualityList.set(i, drumsInitialQualityList.get(i));
                    } else {
                        drumCurrentQualityList.remove(i);
                        drumsInitialQualityList.remove(i);
                        i--;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (Integer integer : drumCurrentQualityList) {
            System.out.print(integer + " ");
        }

        System.out.println();

        System.out.printf("Gabsy has %.02flv.", budget);

    }
}
