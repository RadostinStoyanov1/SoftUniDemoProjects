package P23ObjectsAndClasses_Exercises.P04Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());

        List<Student> studentsList = new ArrayList<>();
        for (int i = 1; i <= countStudents; i++) {
            String input = scanner.nextLine();
            String currentFirstName = input.split("\\s+")[0];
            String currentLastName = input.split("\\s+")[1];
            double currentGrade = Double.parseDouble(input.split("\\s+")[2]);

            Student currentStudent = new Student(currentFirstName, currentLastName, currentGrade);
            studentsList.add(currentStudent);
        }

        studentsList.sort(Comparator.comparing(Student::getGrade).reversed().thenComparing(Comparator.comparing(Student::getFirstName)));
        for (Student student : studentsList) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }

    }
}
