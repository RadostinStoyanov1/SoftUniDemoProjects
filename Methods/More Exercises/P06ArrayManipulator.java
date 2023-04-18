package P15Methods_More_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String typeCommand = command.split(" ")[0];

            switch (typeCommand) {
                case "exchange":
                    numbersArr = exchangeIndex(numbersArr, command);
                    break;
                case "max":
                    maxOddEvenIndex(numbersArr, command);
                    break;
                case "min":
                    minOddEvenIndex(numbersArr, command);
                    break;
                case "first":
                    firstNEvenOddNumbers(numbersArr, command);
                    break;
                case "last":
                    lastNEvenOddNumbers(numbersArr, command);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbersArr));

    }

    public static int[] exchangeIndex (int[] input, String command) {
        int index = Integer.parseInt(command.split(" ")[1]);
        if (index < 0 || index > input.length - 1) {
            System.out.println("Invalid index");
            return input;
        } else {
            int[] currentArr = new int[input.length];
            int counter = 0;
            for (int i = index + 1; ; i++) {
                if (counter == input.length) {
                    break;
                }
                if (i == input.length) {
                    i = 0;
                }
                currentArr[counter] = input[i];
                counter++;
            }
            return currentArr;
        }
    }

    public static void maxOddEvenIndex (int[] input, String command) {
        String typeCommand = command.split(" ")[1];
        if (typeCommand.equals("even")) {
            int maxEvenElement = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < input.length; i++) {
                if (input[i] % 2 == 0 && input[i] >= max) {
                    maxEvenElement = i;
                    max = input[i];
                }
            }
            if (maxEvenElement == -1) {
                System.out.println("No matches");
            } else {
                System.out.println(maxEvenElement);
            }
        } else if (typeCommand.equals("odd")) {
            int maxOddElement = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < input.length; i++) {
                if (input[i] % 2 != 0 && input[i] >= max) {
                    maxOddElement = i;
                    max = input[i];
                }
            }
            if (maxOddElement == -1) {
                System.out.println("No matches");
            } else {
                System.out.println(maxOddElement);
            }
        }
    }

    public static void minOddEvenIndex (int[] input, String command) {
        String typeCommand = command.split(" ")[1];
        if (typeCommand.equals("even")) {
            int minEvenElement = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < input.length; i++) {
                if (input[i] % 2 == 0 && input[i] <= min) {
                    minEvenElement = i;
                    min = input[i];
                }
            }
            if (minEvenElement == -1) {
                System.out.println("No matches");
            } else {
                System.out.println(minEvenElement);
            }
        } else if (typeCommand.equals("odd")) {
            int minOddElement = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < input.length; i++) {
                if (input[i] % 2 != 0 && input[i] <= min) {
                    minOddElement = i;
                    min = input[i];
                }
            }
            if (minOddElement == -1) {
                System.out.println("No matches");
            } else {
                System.out.println(minOddElement);
            }
        }
    }

    public static void firstNEvenOddNumbers (int[] input, String command) {
        int n = Integer.parseInt(command.split(" ")[1]);
        if (n > input.length) {
            System.out.println("Invalid count");
            return;
        }
        String evenOrOdd = command.split(" ")[2];
        int[] output = new int[0];
        if (evenOrOdd.equals("even")) {
            int counter = 0;
            for (int i = 0; i < input.length; i++) {
                if (counter == n) {
                    break;
                }
                if (input[i] % 2 == 0) {
                    int[] newArr = new int[output.length + 1];
                    for (int j = 0; j < counter; j++) {
                        newArr[j] = output[j];
                    }
                    newArr[counter] = input[i];
                    output = newArr;
                    counter++;
                }
            }
            System.out.println(Arrays.toString(output));
        } else if (evenOrOdd.equals("odd")) {
            int counter = 0;
            for (int i = 0; i < input.length; i++) {
                if (counter == n) {
                    break;
                }
                if (input[i] % 2 != 0) {
                    int[] newArr = new int[output.length + 1];
                    for (int j = 0; j < counter; j++) {
                        newArr[j] = output[j];
                    }
                    newArr[counter] = input[i];
                    output = newArr;
                    counter++;
                }
            }
            System.out.println(Arrays.toString(output));
        }
    }

    public static void lastNEvenOddNumbers (int[] input, String command) {
        int n = Integer.parseInt(command.split(" ")[1]);
        if (n > input.length) {
            System.out.println("Invalid count");
            return;
        }
        String evenOrOdd = command.split(" ")[2];
        int[] output = new int[0];
        if (evenOrOdd.equals("even")) {
            int counter = 0;
            for (int i = input.length - 1; i >= 0; i--) {
                if (counter == n) {
                    break;
                }
                if (input[i] % 2 == 0) {
                    int[] newArr = new int[output.length + 1];
                    for (int j = 0; j < counter; j++) {
                        newArr[j] = output[j];
                    }
                    newArr[counter] = input[i];
                    output = newArr;
                    counter++;
                }
            }
            int[] oppositeOutput = new int[output.length];
            for (int i = 0; i < oppositeOutput.length; i++) {
                oppositeOutput[i] = output[output.length - 1 - i];
            }
            System.out.println(Arrays.toString(oppositeOutput));
        } else if (evenOrOdd.equals("odd")) {
            int counter = 0;
            for (int i = input.length - 1; i >= 0; i--) {
                if (counter == n) {
                    break;
                }
                if (input[i] % 2 != 0) {
                    int[] newArr = new int[output.length + 1];
                    for (int j = 0; j < counter; j++) {
                        newArr[j] = output[j];
                    }
                    newArr[counter] = input[i];
                    output = newArr;
                    counter++;
                }
            }
            int[] oppositeOutput = new int[output.length];
            for (int i = 0; i < oppositeOutput.length; i++) {
                oppositeOutput[i] = output[output.length - 1 - i];
            }
            System.out.println(Arrays.toString(oppositeOutput));
        }
    }

}
