package P18List_More_Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numbersList2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        boolean firstListLonger = numbersList1.size() > numbersList2.size();
        List<Integer> mixedList = new ArrayList<>();

        while (numbersList1.size() > 0 && numbersList2.size() > 0) {
            mixedList.add(numbersList1.get(0));
            numbersList1.remove(0);
            mixedList.add(numbersList2.get(numbersList2.size() - 1));
            numbersList2.remove(numbersList2.size() - 1);
        }

        List<Integer> limits = new ArrayList<>();

        if (firstListLonger) {
            limits = numbersList1;
        } else {
            limits = numbersList2;
        }

        Collections.sort(limits);

        int lowLimit = limits.get(0);
        int highLimit = limits.get(1);

        mixedList.removeIf(num -> num <= lowLimit);
        mixedList.removeIf(num -> num >= highLimit);
        Collections.sort(mixedList);

        for (Integer integer : mixedList) {
            System.out.print(integer + " ");
        }

    }

}
