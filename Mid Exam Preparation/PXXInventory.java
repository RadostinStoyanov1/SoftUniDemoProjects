package P20ExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PXXInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            String element = command.split(" - ")[1];
            if (command.startsWith("Collect")) {
                if (!journal.contains(element)) {
                    journal = collectItem(journal, element);
                }
            } else if (command.startsWith("Drop")) {
                if (journal.contains(element)) {
                    journal = dropItem(journal, element);
                }
            } else if (command.startsWith("Combine")) {
                String oldElement = element.split("\\:")[0];
                if (journal.contains(oldElement)) {
                    String newElement = element.split("\\:")[1];
                    journal = combineElements(journal, oldElement, newElement);
                }
            } else if (command.startsWith("Renew")) {
                if (journal.contains(element)) {
                    journal = renewElement(journal, element);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", journal));

    }

    public static List<String> collectItem(List<String> journal, String element) {
        journal.add(element);
        return journal;
    }

    public static List<String> dropItem(List<String> journal, String element) {
        journal.removeAll(Arrays.asList(element));
        return journal;
    }

    public static List<String> combineElements(List<String> journal, String oldElement, String newElement) {
        int oldElementIndex = journal.indexOf(oldElement);
        if (oldElementIndex == journal.size() - 1) {
            journal.add(newElement);
        } else {
            journal.add(oldElementIndex + 1, newElement);
        }
        return journal;
    }

    public static List<String> renewElement(List<String> journal, String element) {
        String movedElement = journal.get(journal.indexOf(element));
        journal.remove(element);
        journal.add(movedElement);
        return journal;
    }

}
