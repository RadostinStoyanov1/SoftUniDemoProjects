package P20ExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PXXMovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsSeq = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.startsWith("Shoot")) {
                targetsSeq = shootTarget(targetsSeq, command);
            } else if (command.startsWith("Add")) {
                targetsSeq = addTarget(targetsSeq, command);
            } else if (command.startsWith("Strike")) {
                targetsSeq = strikeTarget(targetsSeq, command);
            }

            command = scanner.nextLine();
        }

        System.out.println(targetsSeq.toString().replace("[", "").replace("]", "").replaceAll(", ", "\\|"));

    }

    public static List<Integer> shootTarget(List<Integer> targetsSeq, String command) {
        int targetIndex = Integer.parseInt(command.split("\\s+")[1]);
        int power = Integer.parseInt(command.split("\\s+")[2]);
        if (targetIndex >= 0 && targetIndex < targetsSeq.size()) {
            targetsSeq.set(targetIndex, targetsSeq.get(targetIndex) - power);
            if (targetsSeq.get(targetIndex) <= 0) {
                targetsSeq.remove(targetIndex);
            }
        }
        return targetsSeq;
    }

    public static List<Integer> addTarget(List<Integer> targetsSeq, String command) {
        int indexToAdd = Integer.parseInt(command.split("\\s+")[1]);
        int targetPower = Integer.parseInt(command.split("\\s+")[2]);
        if (indexToAdd >=0 && indexToAdd < targetsSeq.size()) {
            targetsSeq.add(indexToAdd, targetPower);
        } else {
            System.out.println("Invalid placement!");
        }
        return targetsSeq;
    }

    public static List<Integer> strikeTarget(List<Integer> targetsSeq, String command) {
        int index = Integer.parseInt(command.split("\\s+")[1]);
        int radius = Integer.parseInt(command.split("\\s+")[2]);
        int leftIndex = index - radius;
        int rightIndex = index + radius;
        if (leftIndex < 0 || rightIndex >= targetsSeq.size()) {
            System.out.println("Strike missed!");
        } else {
            int elementsToRemove = rightIndex - leftIndex + 1;
            int deleteCounter = 0;
            for (int i = leftIndex; ; ) {
                if (deleteCounter == elementsToRemove) {
                    break;
                }
                targetsSeq.remove(i);
                deleteCounter++;
            }
        }
        return targetsSeq;
    }

}
