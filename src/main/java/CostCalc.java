import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CostCalc {
    public static double calculateCost(double consumption, double distance, double price) {
        return (consumption * distance * price);
    }

    public static double calculateFuelNeeded(double consumption, double distance) {
        return (consumption * distance);
    }

    public static void main(String[] args) {
        System.out.println("Select a language: ");
        System.out.println("1. Farsi");
        System.out.println("2. Finnish");
        System.out.println("3. Japanese");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Locale locale = switch (choice) {
            case 1 -> {
                System.out.println("You selected Farsi.");
                yield new Locale("fa", "IR");
            }
            case 2 -> {
                System.out.println("You selected Finnish.");
                yield new Locale("fi", "FI");
            }
            case 3 -> {
                System.out.println("You selected Japanese.");
                yield new Locale("ja", "JP");
            }
            default -> {
                System.out.println("Invalid language.");
                yield new Locale("en", "US");
            }
        };

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid language.");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        double consumption = (5/100.0);
        System.out.println(rb.getString("kilo"));
        double distance = scanner.nextDouble();
        System.out.println(rb.getString("price"));
        double price = scanner.nextDouble();

        System.out.println(rb.getString("total") + calculateCost(consumption, distance, price) + "€");
        System.out.println(rb.getString("fuel") + calculateFuelNeeded(consumption, distance) + "L");
        scanner.close();
    }
}
