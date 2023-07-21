package P35ExamPreparation2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(@|#)(?<pair1>[A-Za-z]{3,})(\\1)(\\1)(?<pair2>[A-Za-z]{3,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        List<String> pairsList = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        int pairsCounter = 0;

        while (matcher.find()) {
            pairsCounter++;
            String word1 = matcher.group("pair1");
            String word2 = matcher.group("pair2");

            boolean isPalindrome = isPalindromeWords(word1, word2);

            if (isPalindrome) {
                String elementToAdd = word1 + " <=> " + word2;
                pairsList.add(elementToAdd);
            }
            
        }

        if (pairsCounter == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", pairsCounter);
        }

        if (pairsList.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", pairsList));
        }

    }
    
    public static boolean isPalindromeWords(String word1, String word2) {
        String reversedWord1 = "";
        for (int i = word1.length() - 1; i >= 0; i--) {
            reversedWord1 += word1.charAt(i);
        }

        boolean isPalindrome = false;

        if (reversedWord1.equals(word2)) {
            isPalindrome = true;
        }

        return isPalindrome;
    }
    
}
