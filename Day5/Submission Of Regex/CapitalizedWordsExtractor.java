import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> capitalizedWords = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        System.out.println(capitalizedWords);
    }
}
