import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> repeats = new LinkedHashSet<>();

        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            repeats.add(matcher.group(1).toLowerCase());
        }

        System.out.println(repeats);
    }
}
