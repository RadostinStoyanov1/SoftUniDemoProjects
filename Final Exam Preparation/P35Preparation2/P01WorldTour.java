package P35ExamPreparation2;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String command =scanner.nextLine();

        while (!command.equals("Travel")) {
            if (command.startsWith("Add")) {
                int index = Integer.parseInt(command.split(":")[1]);
                if (index >= 0 && index < stops.length()) {
                    String addingStop = command.split(":")[2];
                    stops.insert(index, addingStop);
                }
            } else if (command.startsWith("Remove")) {
                int index1 = Integer.parseInt(command.split(":")[1]);
                int index2 = Integer.parseInt(command.split(":")[2]);
                if (index1 > index2) {
                    int tempIndex = index1;
                    index1 = index2;
                    index2 = tempIndex;
                }
                if (index1 >= 0 && index1 < stops.length() && index2 >= 0 && index2 < stops.length()) {
                    stops.replace(index1, index2 + 1, "");
                }
            } else if (command.startsWith("Switch")) {
                String removeText = command.split(":")[1];
                String newText = command.split(":")[2];

                if (stops.toString().contains(removeText)) {
                    String currentString = stops.toString();
                    currentString = currentString.replaceAll(removeText, newText);
                    stops = new StringBuilder(currentString);
                }
            }

            System.out.println(stops.toString());

            command = scanner.nextLine();
        }

        System.out.print("Ready for world tour! Planned stops: ");
        System.out.println(stops.toString());

    }
}
