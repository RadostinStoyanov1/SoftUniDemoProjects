package P17List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            if (input.contains("Contains")) {
                if (intList.contains(Integer.parseInt(input.split(" ")[1]))) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (input.equals("Print even")) {
                for (Integer element : intList) {
                    if (element % 2 == 0) {
                        System.out.print(element + " ");
                    }
                }
                System.out.println();
            } else if (input.equals("Print odd")) {
                for (Integer element : intList) {
                    if (element % 2 != 0) {
                        System.out.print(element + " ");
                    }
                }
                System.out.println();
            } else if (input.equals("Get sum")) {
                int sum = 0;
                for (Integer element : intList) {
                    sum += element;
                }
                System.out.println(sum);
            } else if (input.contains("Filter")) {
                int num = Integer.parseInt(input.split(" ")[2]);
                switch (input.split(" ")[1]) {
                    case "<":
                        for (Integer element : intList) {
                            if (element < num) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                        break;
                    case ">":
                        for (Integer element : intList) {
                            if (element > num) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                        break;
                    case "<=":
                        for (Integer element : intList) {
                            if (element <= num) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();
                        break;
                    case ">=":
                        for (Integer element : intList) {
                            if (element >= num) {
                                System.out.print(element + " ");
                            }
                        }
                        System.out.println();

                }
            }


            input = scanner.nextLine();
        }

    }
}
