public class CreditCardValidator {
    public static void main(String[] args) {
        String[] testCards = {
            "4123456789012345",
            "5123456789012345",
            "6123456789012345",
            "412345678901234",
            "51234567890123456"
        };

        for (String card : testCards) {
            System.out.println(card + " => " + isValidCard(card));
        }
    }

    public static boolean isValidCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }
}
