package P22ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06Students2 {

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

        public void setTown(String town) {
            this.town = town;
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

        public void setAge(String age) {
            this.age = age;
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

            if (checkExistingStudent(studentList, firstName, lastName)) {
                int index = getExistingIndex(studentList, firstName, lastName);
                studentList.get(index).setAge(age);
                studentList.get(index).setTown(town);
            } else {
                Student currentStudent = new Student(firstName, lastName, age, town);
                studentList.add(currentStudent);
            }

            input = scanner.nextLine();
        }

        String homeTown = scanner.nextLine();

        for (Student student : studentList) {
            if(student.getTown().equals(homeTown)) {
                System.out.printf("%s %s is %s years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }

    }

    public static boolean checkExistingStudent(List<Student> studentList, String firstName, String secondName) {
        for (Student student : studentList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(secondName)) {
                return true;
            }
        }
        return false;
    }

    public static int getExistingIndex(List<Student> studentList, String firstName, String lastName) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                index = i;
                break;
            }
        }
        return index;

    }

}
