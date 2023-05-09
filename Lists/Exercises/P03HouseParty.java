package P18List_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommands = Integer.parseInt(scanner.nextLine());

        List<String> namesParticipants = new ArrayList<>();

        for (int i = 1; i <= numCommands; i++) {
            String command = scanner.nextLine();

            String[] commandArr = command.split(" ");

            if (commandArr.length == 3) {
                if(namesParticipants.contains(commandArr[0])) {
                    System.out.printf("%s is already in the list!%n", commandArr[0]);
                } else {
                    namesParticipants.add(commandArr[0]);
                }
            } else if (commandArr.length == 4) {
                if(namesParticipants.contains(commandArr[0])) {
                    namesParticipants.remove(commandArr[0]);
                } else {
                    System.out.printf("%s is not in the list!%n", commandArr[0]);
                }
            }

        }

        for (String namesParticipant : namesParticipants) {
            System.out.println(namesParticipant);
        }

    }
}
