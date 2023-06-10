package P23ObjectsAndClasses_Exercises.P03OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                personsList.add(person);
            }
        }

        for (Person person : personsList) {
            System.out.println(person.getName() + " - " + person.getAge());
        }

    }
}
