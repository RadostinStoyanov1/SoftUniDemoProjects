package P18List_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> programList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")) {
            List<String> commandList = Arrays.stream(command.split(":")).collect(Collectors.toList());

            if(command.startsWith("Add")) {
                programList = addLesson(programList, commandList);
            } else if (command.startsWith("Insert")) {
                programList = insertLessonAtIndex(programList, commandList);
            } else if (command.startsWith("Remove")) {
                programList = removeLesson(programList, commandList);
            } else if (command.startsWith("Swap")) {
                programList = swapLessons(programList, commandList);
            } else if (command.startsWith("Exercise")) {
                programList = addExercise(programList, commandList);
            }


            command = scanner.nextLine();
        }

        for (int i = 0; i < programList.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, programList.get(i));
        }

    }

    public static List<String> addLesson(List<String> programList, List<String> commandList) {
        if (programList.contains(commandList.get(1))) {

        } else {
            programList.add(commandList.get(1));
        }
        return programList;
    }

    public static List<String> insertLessonAtIndex(List<String> programList, List<String> commandList) {
        if (programList.contains(commandList.get(1))) {

        } else {
            programList.add(Integer.parseInt(commandList.get(2)), commandList.get(1));
        }
        return programList;
    }

    public static List<String> removeLesson(List<String> programList, List<String> commandList) {
        if (programList.contains(commandList.get(1))) {
            int indexOfDeletedLesson = programList.indexOf(commandList.get(1));
            if (indexOfDeletedLesson < programList.size() - 1 && programList.get(indexOfDeletedLesson + 1).startsWith(commandList.get(1))) {
                programList.remove(indexOfDeletedLesson + 1);
            }
            programList.remove(indexOfDeletedLesson);
        }
        return programList;
    }

    public static List<String> swapLessons(List<String> programList, List<String> commandList) {
        if (programList.contains(commandList.get(1)) && programList.contains(commandList.get(2))) {
            String firstLessonName = commandList.get(1);
            int indexOfFirstLesson = programList.indexOf(firstLessonName);
            String secondLessonName = commandList.get(2);
            int indexOfSecondLesson = programList.indexOf(secondLessonName);
            boolean firstLessonHasExercise = false;
            boolean secondLessonHasExercise = false;

            if (indexOfFirstLesson < programList.size() - 1 && programList.get(indexOfFirstLesson + 1).startsWith(firstLessonName)) {
                firstLessonHasExercise = true;
            }
            if (indexOfSecondLesson < programList.size() - 1 && programList.get(indexOfSecondLesson + 1).startsWith(secondLessonName)) {
                secondLessonHasExercise = true;
            }

            programList.set(indexOfFirstLesson, secondLessonName);
            programList.set(indexOfSecondLesson, firstLessonName);

            if (firstLessonHasExercise && secondLessonHasExercise) {
                programList.set(indexOfFirstLesson + 1, programList.get(indexOfSecondLesson + 1));
                programList.set(indexOfSecondLesson + 1, programList.get(indexOfFirstLesson + 1));
            } else if (firstLessonHasExercise && !secondLessonHasExercise) {
                programList.add(indexOfSecondLesson + 1, programList.get(indexOfFirstLesson + 1));
                programList.remove(indexOfFirstLesson + 1);
            } else if (!firstLessonHasExercise && secondLessonHasExercise) {
                programList.add(indexOfFirstLesson + 1, programList.get(indexOfSecondLesson + 1));
                programList.remove(indexOfSecondLesson + 2);
            }

        }
        return programList;
    }

    public static List<String> addExercise(List<String> programList, List<String> commandList) {
        String exerciseNameAsElement = commandList.get(1) + "-" + commandList.get(0);
        String lessonName = commandList.get(1);
        if (programList.contains(lessonName)) {
            if (!programList.contains(exerciseNameAsElement)) {
                int indexOfLesson = programList.indexOf(lessonName);
                programList.add(indexOfLesson + 1, exerciseNameAsElement);
            }
        } else {
            programList.add(lessonName);
            programList.add(exerciseNameAsElement);
        }
        return programList;
    }

}
