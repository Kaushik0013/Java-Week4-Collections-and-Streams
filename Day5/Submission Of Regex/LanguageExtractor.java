import java.util.*;
import java.util.regex.*;

public class LanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin");
        List<String> found = new ArrayList<>();

        for (String lang : languages) {
            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(lang) + "\\b");
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                found.add(lang);
            }
        }

        System.out.println(found);
    }
}
