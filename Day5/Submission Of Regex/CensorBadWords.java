import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = { "damn", "stupid" };


        for (String badWord : badWords) {
            text = text.replaceAll("(?i)\\b" + Pattern.quote(badWord) + "\\b", "****");
        }

        System.out.println(text);
    }
}
