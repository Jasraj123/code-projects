import java.text.DecimalFormat;
import java.util.Scanner;

public class Currency_Converter {
    private final String[] currencies = {"USD", "EUR", "JPY", "GBP", "CAD", "AUD", "CHF", "CNY", "INR"};
    private final double[] exchangeRates = {1.00, 0.88, 110.50, 0.75, 1.30, 1.35, 0.95, 6.80, 90.00};
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    public static void main(String[] args) {
        new Currency_Converter().start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");

        while (true) {
            System.out.print("Enter the amount: ");
            double amount = readDouble(scanner);

            System.out.print("From (e.g., USD): ");
            String fromCurrency = scanner.next().toUpperCase();

            System.out.print("To (e.g., EUR): ");
            String toCurrency = scanner.next().toUpperCase();

            double result = convert(amount, fromCurrency, toCurrency);
            System.out.println("Converted amount: " + decimalFormat.format(result) + " " + toCurrency);

            System.out.print("Want to convert another amount? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (response.equals("no")) {
                System.out.println("Thank you for using Currency Converter. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next(); 
        }
        return scanner.nextDouble();
    }

    private double convert(double amount, String fromCurrency, String toCurrency) {
        double exchangeRate = exchangeRates[getIndex(toCurrency)] / exchangeRates[getIndex(fromCurrency)];
        return amount * exchangeRate;
    }

    private int getIndex(String currency) {
        for (int i = 0; i < currencies.length; i++) {
            if (currency.equals(currencies[i])) {
                return i;
            }
        }
        return -1;
    }
}
