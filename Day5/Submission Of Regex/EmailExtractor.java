import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class EmailExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(input);

        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No email addresses found.");
        }

        scanner.close();
    }
}
