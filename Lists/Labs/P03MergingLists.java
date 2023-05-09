package P17List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        if (list1.size() >= list2.size()) {
            for (int i = 0; i <= list1.size() - 1; i++) {
                if (i < list2.size()){
                    result = addSameIndexElementsFrom2Lists(list1, list2, result, i);
                } else {
                    result = addElementOnNthListIndex(list1, result, i);
                }

            }
        } else {
            for (int i = 0; i <= list2.size() - 1; i++) {
                if (i < list1.size()){
                    result = addSameIndexElementsFrom2Lists(list1, list2, result, i);
                } else {
                    result = addElementOnNthListIndex(list2, result, i);
                }

            }
        }

        for (Integer element : result) {
            System.out.print(element + " ");
        }

    }

    public static List<Integer> addSameIndexElementsFrom2Lists(List<Integer> input1, List<Integer> input2, List<Integer> result, int index) {
        result.add(input1.get(index));
        result.add(input2.get(index));
        return result;
    }

    public static List<Integer> addElementOnNthListIndex (List<Integer> sourceList, List<Integer> result, int index) {
        result.add(sourceList.get(index));
        return result;
    }

}
