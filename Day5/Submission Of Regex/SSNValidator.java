import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String[] testInputs = {
            "My SSN is 123-45-6789.",
            "Another format: 123456789.",
            "Invalid: 12-345-6789"
        };

        for (String text : testInputs) {
            String result = extractAndValidateSSN(text);
            System.out.println(result);
        }
    }

    public static String extractAndValidateSSN(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return "\"" + matcher.group() + "\" is valid";
        } else {
            return " No valid SSN found";
        }
    }
}
