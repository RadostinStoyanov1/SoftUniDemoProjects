package P18List_More_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> raceElements = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int numStages = raceElements.size() / 2;

        double firstRacerTime = 0;
        double secondRacerTime = 0;

        for (int i = 0; i < numStages ; i++) {
            if (raceElements.get(i) == 0) {
                firstRacerTime *= 0.8;
            } else {
                firstRacerTime += raceElements.get(i);
            }
        }

        for (int i = raceElements.size() - 1; i > (raceElements.size() / 2); i--) {
            if (raceElements.get(i) == 0) {
                secondRacerTime *= 0.8;
            } else {
                secondRacerTime += raceElements.get(i);
            }
        }

        String winner = "";
        double winnerTime = 0;

        if (firstRacerTime < secondRacerTime) {
            winner = "left";
            winnerTime = firstRacerTime;
        } else if (firstRacerTime > secondRacerTime) {
            winner = "right";
            winnerTime = secondRacerTime;
        }

        System.out.printf("The winner is %s with total time: %.01f", winner, winnerTime);

    }
}
