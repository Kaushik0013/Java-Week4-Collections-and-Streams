import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = new ArrayList<>();

        Pattern pattern = Pattern.compile("https?://[^\\s]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            links.add(matcher.group());
        }

        System.out.println(links);
    }
}
