package P23ObjectsAndClasses_Exercises.P06OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Person> personsList = new ArrayList<>();

        while (!command.equals("End")) {
            String currentName = command.split("\\s+")[0];
            String currentID = command.split("\\s+")[1];
            int currentAge = Integer.parseInt(command.split("\\s+")[2]);
            Person person = new Person(currentName, currentID, currentAge);
            personsList.add(person);

            command = scanner.nextLine();
        }

        personsList.sort(Comparator.comparing(Person::getAge));

        for (Person person : personsList) {
            System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getiD(), person.getAge());
        }

    }
}
