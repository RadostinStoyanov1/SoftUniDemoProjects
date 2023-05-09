package P18List_More_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03TakeOrSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String enter = scanner.nextLine();

        List<String> inputList = new ArrayList<>();

        for (int i = 0; i < enter.length(); i++) {
            String currentChar = "" + enter.charAt(i);
            inputList.add(currentChar);
        }

        List<Integer> numList = new ArrayList<>();
        List<String> nonNumList = new ArrayList<>();

        for (int i = 0; i < inputList.size(); i++) {
            char currentChar = inputList.get(i).charAt(0);
            if (Character.isDigit(currentChar)) {
                int numToAdd = Integer.parseInt("" + currentChar);
                numList.add(numToAdd);;
            } else {
                String charToAdd = "" + currentChar;
                nonNumList.add(charToAdd);
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numList.get(i));
            } else {
                skipList.add(numList.get(i));
            }
        }

        if(numList.size() % 2 != 0) {
            skipList.add(0);
        }

        int nonNumListIndex = 0; //за да може да брои взетите и пропуснатите индекси в нечисловия списък;
        String encryptedMessage = "";
        for (int i = 0; i < takeList.size(); i++) { // вземам i-ия индекс от take и skip листовете и трябва да ги проверя в nonNumList
            int takeNum = takeList.get(i);
            int skipNum = skipList.get(i);
            boolean isBreak = false;
            for (int j = 0; j < takeNum; j++) {
                encryptedMessage += nonNumList.get(nonNumListIndex);
                nonNumListIndex++;
                if (nonNumListIndex >= nonNumList.size()) {
                    isBreak = true;
                    break;
                }
            }

            if (isBreak) {
                break;
            }
            for (int k = 0; k < skipNum; k++) {
                nonNumListIndex++;
            }

            if (nonNumListIndex >= nonNumList.size()) {
                break;
            }

        }

        System.out.println(encryptedMessage);

    }

}
