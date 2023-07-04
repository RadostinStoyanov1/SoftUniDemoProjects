package P29TextProcessing_More_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> morseCode = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());

        List<String> outputSentence = new ArrayList<>();

        for (String word : morseCode) {
            String[] morseChars = word.split(" ");
            outputSentence.add(convertMorseWord(morseChars));
        }

        System.out.println(String.join(" ", outputSentence));

    }

    public static String convertMorseWord (String[] morseChars) {
        StringBuilder outputWord = new StringBuilder();
        for (String morse : morseChars) {
            switch (morse) {
                case ".-":
                    outputWord.append("A");
                    break;
                case "-...":
                    outputWord.append("B");
                    break;
                case "-.-.":
                    outputWord.append("C");
                    break;
                case "-..":
                    outputWord.append("D");
                    break;
                case ".":
                    outputWord.append("E");
                    break;
                case "..-.":
                    outputWord.append("F");
                    break;
                case "--.":
                    outputWord.append("G");
                    break;
                case "....":
                    outputWord.append("H");
                    break;
                case "..":
                    outputWord.append("I");
                    break;
                case ".---":
                    outputWord.append("J");
                    break;
                case "-.-":
                    outputWord.append("K");
                    break;
                case ".-..":
                    outputWord.append("L");
                    break;
                case "--":
                    outputWord.append("M");
                    break;
                case "-.":
                    outputWord.append("N");
                    break;
                case "---":
                    outputWord.append("O");
                    break;
                case ".--.":
                    outputWord.append("P");
                    break;
                case "--.-":
                    outputWord.append("Q");
                    break;
                case ".-.":
                    outputWord.append("R");
                    break;
                case "...":
                    outputWord.append("S");
                    break;
                case "-":
                    outputWord.append("T");
                    break;
                case "..-":
                    outputWord.append("U");
                    break;
                case "...-":
                    outputWord.append("V");
                    break;
                case ".--":
                    outputWord.append("W");
                    break;
                case "-..-":
                    outputWord.append("X");
                    break;
                case "-.--":
                    outputWord.append("Y");
                    break;
                case "--..":
                    outputWord.append("Z");
                    break;
                case "-----":
                    outputWord.append("0");
                    break;
                case ".----":
                    outputWord.append("1");
                    break;
                case "..---":
                    outputWord.append("2");
                    break;
                case "...--":
                    outputWord.append("3");
                    break;
                case "....-":
                    outputWord.append("4");
                    break;
                case ".....":
                    outputWord.append("5");
                    break;
                case "-....":
                    outputWord.append("6");
                    break;
                case "--...":
                    outputWord.append("7");
                    break;
                case "---..":
                    outputWord.append("8");
                    break;
                case "----.":
                    outputWord.append("9");
                    break;

            }
        }
        return outputWord.toString();
    }

}
