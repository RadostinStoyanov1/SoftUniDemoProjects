package P18List_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersSequence = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int sumOfRemovedElements = 0;

        while (numbersSequence.size() > 0) {
            int indexToBeRemoved = Integer.parseInt(scanner.nextLine());

            boolean removeElement = true;
            int elementToBeRemoved = 0;

            if (indexToBeRemoved < 0) {
                indexToBeRemoved = 0;
                elementToBeRemoved = numbersSequence.get(indexToBeRemoved);
                numbersSequence.set(0, numbersSequence.get(numbersSequence.size() - 1));
                removeElement = false;
            } else if (indexToBeRemoved > numbersSequence.size() - 1) {
                indexToBeRemoved = numbersSequence.size() - 1;
                elementToBeRemoved = numbersSequence.get(indexToBeRemoved);
                numbersSequence.set(numbersSequence.size() - 1, numbersSequence.get(0));
                removeElement = false;
            }

            if (removeElement) {
                elementToBeRemoved = numbersSequence.get(indexToBeRemoved);
                numbersSequence.remove(indexToBeRemoved);
            }

            sumOfRemovedElements += elementToBeRemoved;
            numbersSequence = increaseAndDecreaseAllElements(numbersSequence, elementToBeRemoved);
        }

        System.out.println(sumOfRemovedElements);

    }

    public static List<Integer> increaseAndDecreaseAllElements(List<Integer> numberSequence, int elementToBeRemoved) {
        for (int i = 0; i < numberSequence.size(); i++) {
            if (numberSequence.get(i) <= elementToBeRemoved) {
                numberSequence.set(i, numberSequence.get(i) + elementToBeRemoved);
            } else {
                numberSequence.set(i, numberSequence.get(i) - elementToBeRemoved);
            }
        }
        return numberSequence;
    }

    public static List<Integer> decreaseAllElementsHigherThanRemovedElement(List<Integer> numberSequence, int elementToBeRemoved) {
        for (int i = 0; i < numberSequence.size(); i++) {
            if (numberSequence.get(i) >= elementToBeRemoved) {
                numberSequence.set(i, numberSequence.get(i) - elementToBeRemoved);
            }
        }
        return numberSequence;
    }

}
