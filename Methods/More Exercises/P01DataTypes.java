package P15Methods_More_Exercises;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputType = scanner.nextLine();
        String inputData = scanner.nextLine();

        readData(inputType, inputData);

    }

    public static void readData (String input, String data) {
        if (input.equals("int")) {
            int number = Integer.parseInt(data);
            print(number);
        } else if (input.equals("real")) {
            double number = Double.parseDouble(data);
            print(number);
        } else if (input.equals("string")) {
            print(data);
        }
    }

    public static void print (int number) {
        System.out.println(number * 2);
    }

    public static void print (double number) {
        double result = number * 1.5;
        System.out.printf("%.2f%n", result);
    }

    public static void print (String input) {
        System.out.println("$" + input + "$");
    }

}

