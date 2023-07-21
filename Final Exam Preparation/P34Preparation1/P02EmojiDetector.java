package P34ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        long coolThreshold = 1;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                int currentDigit = Integer.parseInt(c + "");
                coolThreshold *= currentDigit;
            }
        }

        String regex = "(:{2}|\\*{2})(?<emoji>[A-Z][a-z]{2,})(\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> emojiList = new ArrayList<>();
        int emojiCounter = 0;

        while (matcher.find()) {
            emojiCounter++;
            String currentEmoji = matcher.group("emoji");

            int currentEmojiCoolness = 0;

            for (char c : currentEmoji.toCharArray()) {
                int num = (int)c;
                currentEmojiCoolness += num;
            }

            if (currentEmojiCoolness >= coolThreshold) {
                emojiList.add(matcher.group());
            }
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCounter);
        for (String s : emojiList) {
            System.out.println(s);
        }

    }
}
