package P32RegularExpressions_Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<user>[A-za-z0-9]+[.\\-_]?[A-za-z0-9]+)@(?<host>[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+-?[A-Za-z]+)+)";
        Pattern pattern = Pattern.compile(regex);

        String text = scanner.nextLine();

        Matcher matcher = pattern.matcher(text);
        //Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information.

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
