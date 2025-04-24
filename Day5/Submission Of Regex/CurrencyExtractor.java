import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> values = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            values.add(matcher.group());
        }

        System.out.println(values);
    }
}
