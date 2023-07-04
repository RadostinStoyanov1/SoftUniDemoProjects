package P29TextProcessing_Execise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pathArr = scanner.nextLine().split("\\\\");

        String lastElement = pathArr[pathArr.length - 1];
        String fileName = lastElement.split("\\.")[0];
        String fileExtension = lastElement.split("\\.")[1];

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", fileExtension);

    }
}
