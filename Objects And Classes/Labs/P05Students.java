package P22ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {

    static class Student {
        String firstName;
        String lastName;
        String age;
        String town;

        public Student (String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getTown() {
            return this.town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Student> studentList = new ArrayList<>();

        while (!input.equals("end")) {
            String[] studentInput = input.split(" ");
            String firstName = studentInput[0];
            String lastName = studentInput[1];
            String age = studentInput[2];
            String town = studentInput[3];

            Student currentStudent = new Student(firstName, lastName, age, town);
            studentList.add(currentStudent);

            input = scanner.nextLine();
        }
        
        String homeTown = scanner.nextLine();

        for (Student student : studentList) {
            if(student.getTown().equals(homeTown)) {
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }

    }
}
