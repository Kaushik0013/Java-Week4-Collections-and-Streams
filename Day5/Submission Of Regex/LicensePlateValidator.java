import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license plate number: ");
        String input = scanner.nextLine();

        if (isValidLicensePlate(input)) {
            System.out.println(" Valid license plate");
        } else {
            System.out.println(" Invalid license plate");
        }

        scanner.close();
    }
}
