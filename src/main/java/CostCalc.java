import java.util.Scanner;

public class CostCalc {
    public static double calculateCost(double consumption, double distance, double price) {
        return (consumption * distance * price);
    }

    public static double calculateFuelNeeded(double consumption, double distance) {
        return (consumption * distance);
    }

    public static void main(String[] args) {
        double consumption = (5/100.0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the distance in km: ");
        double distance = scanner.nextDouble();
        System.out.println("Enter the price per liter: ");
        double price = scanner.nextDouble();

        System.out.println("The cost of the trip is: " + calculateCost(consumption, distance, price));
        System.out.println("The fuel needed for the trip is: " + calculateFuelNeeded(consumption, distance));
        scanner.close();
    }
}
