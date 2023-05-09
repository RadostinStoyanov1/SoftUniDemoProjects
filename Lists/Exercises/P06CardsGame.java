package P18List_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCardsList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCardsList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayerCardsList.size() > 0 && secondPlayerCardsList.size() > 0) {
            if (firstPlayerCardsList.get(0) > secondPlayerCardsList.get(0)) {
                firstPlayerCardsList = winner(firstPlayerCardsList, secondPlayerCardsList);
                secondPlayerCardsList = loser(secondPlayerCardsList);
            } else if (secondPlayerCardsList.get(0) > firstPlayerCardsList.get(0)) {
                secondPlayerCardsList = winner(secondPlayerCardsList, firstPlayerCardsList);
                firstPlayerCardsList = loser(firstPlayerCardsList);
            } else if (firstPlayerCardsList.get(0).equals(secondPlayerCardsList.get(0))) {
                firstPlayerCardsList = loser(firstPlayerCardsList);
                secondPlayerCardsList = loser(secondPlayerCardsList);
            }
        }

        int sum = 0;

        if (firstPlayerCardsList.size() == 0) {
            for (Integer num : secondPlayerCardsList) {
                sum += num;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else if (secondPlayerCardsList.size() == 0) {
            for (Integer num : firstPlayerCardsList) {
                sum += num;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }

    }

    public static List<Integer> winner(List<Integer> winnersCards, List<Integer> losersCards) {
        int winnersCardToMove = winnersCards.get(0);
        int losersCardToMove = losersCards.get(0);
        winnersCards.remove(0);
        winnersCards.add(winnersCardToMove);
        winnersCards.add(losersCardToMove);
        return winnersCards;
    }

    public static List<Integer> loser(List<Integer> losersCards) {
        losersCards.remove(0);
        return losersCards;
    }

}
