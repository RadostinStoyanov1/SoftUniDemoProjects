package P23ObjectsAndClasses_Exercises;

import java.util.Scanner;

public class P02Articles {

    static class Article {
        String title;
        String content;
        String author;

        public Article (String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return this.content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return this.title;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstArticle = scanner.nextLine();
        String[] currentInput = firstArticle.split(", ");
        String currentTitle = currentInput[0];
        String currentContent = currentInput[1];
        String currentAuthor = currentInput[2];

        Article newArticle = new Article(currentTitle, currentContent, currentAuthor);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("Edit:")) {
                String newContent = command.split(": ")[1];
                newArticle.setContent(newContent);
            } else if (command.startsWith("ChangeAuthor:")) {
                String newAuthor = command.split(": ")[1];
                newArticle.setAuthor(newAuthor);
            } else if (command.startsWith("Rename:")) {
                String newTitle = command.split(": ")[1];
                newArticle.setTitle(newTitle);
            }
        }

        System.out.printf("%s - %s: %s%n", newArticle.getTitle(), newArticle.getContent(), newArticle.getAuthor());

    }
}
