import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to Currency Converter!");

        while (true) {
            System.out.println("\nSelect the base currency:\n");
            System.out.println("1. USD (United States Dollar)");
            System.out.println("2. EUR (Euro)");
            System.out.println("3. INR (Indian Rupee)");
            System.out.println("4. YEN (Japanese Yen)");
            System.out.println("5. CAD (Canadian Dollar)");
            System.out.println("6. YUAN (Chinese Yuan)");
            System.out.println("0. Exit");

            int baseCurrencyChoice = getChoice(scanner);

            if (baseCurrencyChoice == 0) {
                break;
            }

            int targetCurrencyChoice = getTargetCurrencyChoice(scanner);

            double amount = getAmount(scanner);

            double convertedAmount = convertCurrency(baseCurrencyChoice, targetCurrencyChoice, amount);

            System.out.println("\nConverted amount: " + convertedAmount);

            System.out.print("\nDo you want to convert another amount? (yes/no): ");
            String response = scanner.next().toLowerCase();

            if (!response.equals("yes")) {
                break;
            }
        }

        System.out.println("\nThank you for using Currency Converter!");
        scanner.close();
    }

    private static int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("\nEnter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= 6) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("\nInvalid choice. Please select a valid option.");
        }
        return choice;
    }

    private static int getTargetCurrencyChoice(Scanner scanner) {
        int targetChoice;
        while (true) {
            System.out.println("\nSelect the target currency:\n");
            System.out.println("1. USD (United States Dollar)");
            System.out.println("2. EUR (Euro)");
            System.out.println("3. INR (Indian Rupee)");
            System.out.println("4. YEN (Japanese Yen)");
            System.out.println("5. CAD (Canadian Dollar)");
            System.out.println("6. YUAN (Chinese Yuan)");

            System.out.print("\nEnter your choice: ");
            if (scanner.hasNextInt()) {
                targetChoice = scanner.nextInt();
                if (targetChoice >= 1 && targetChoice <= 6) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("\nInvalid choice. Please select a valid target currency.");
        }
        return targetChoice;
    }

    private static double getAmount(Scanner scanner) {
        double amount;
        while (true) {
            System.out.print("\nEnter the amount to convert: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount >= 0) {
                    break;
                }
            } else {
                scanner.next(); // Consume invalid input
            }
            System.out.println("\nInvalid amount. Please enter a non-negative number.");
        }
        return amount;
    }

    private static double convertCurrency(int baseCurrencyChoice, int targetCurrencyChoice, double amount) {
        double conversionRate = 0.0;

        switch (baseCurrencyChoice) {
            case 1: // USD (United States Dollar)
                switch (targetCurrencyChoice) {
                    case 1: // USD to USD
                        conversionRate = 1.0;
                        break;
                    case 2: // USD to EUR
                        conversionRate = 0.85;
                        break;
                    case 3: // USD to INR
                        conversionRate = 74.11;
                        break;
                    case 4: // USD to YEN
                        conversionRate = 108.62;
                        break;
                    case 5: // USD to CAD
                        conversionRate = 1.26;
                        break;
                    case 6: // USD to YUAN
                        conversionRate = 6.45;
                        break;
                }
                break;
            case 2: // EUR (Euro)
                switch (targetCurrencyChoice) {
                    case 1: // EUR to USD
                        conversionRate = 1.09;
                        break;
                    case 2: // EUR to EUR
                        conversionRate = 1.0;
                        break;
                    case 3: // EUR to INR
                        conversionRate = 91.14;
                        break;
                    case 4: // EUR to YEN
                        conversionRate = 163.49;
                        break;
                    case 5: // EUR to CAD
                        conversionRate = 1.49;
                        break;
                    case 6: // EUR to YUAN
                        conversionRate = 7.76;
                        break;
                }
                break;
            case 3: // INR (Indian Rupee)
                switch (targetCurrencyChoice) {
                    case 1: // INR to USD
                        conversionRate = 0.012;
                        break;
                    case 2: // INR to EUR
                        conversionRate = 0.01;
                        break;
                    case 3: // INR to INR
                        conversionRate = 1.0;
                        break;
                    case 4: // INR to YEN
                        conversionRate = 1.79;
                        break;
                    case 5: // INR to CAD
                        conversionRate = 0.016;
                        break;
                    case 6: // INR to YUAN
                        conversionRate = 0.08;
                        break;
                }
                break;
            case 4: // YEN (Japanese Yen)
                switch (targetCurrencyChoice) {
                    case 1: // YEN to USD
                        conversionRate = 0.0066;
                        break;
                    case 2: // YEN to EUR
                        conversionRate = 0.0061;
                        break;
                    case 3: // YEN to INR
                        conversionRate = 0.55;
                        break;
                    case 4: // YEN to YEN
                        conversionRate = 1.0;
                        break;
                    case 5: // YEN to CAD
                        conversionRate = 0.0091;
                        break;
                    case 6: // YEN to YUAN
                        conversionRate = 0.047;
                        break;
                }
                break;
            case 5: // CAD (Canadian Dollar)
                switch (targetCurrencyChoice) {
                    case 1: // CAD to USD
                        conversionRate = 0.73;
                        break;
                    case 2: // CAD to EUR
                        conversionRate = 0.67;
                        break;
                    case 3: // CAD to INR
                        conversionRate = 61.10;
                        break;
                    case 4: // CAD to YEN
                        conversionRate = 109.56;
                        break;
                    case 5: // CAD to CAD
                        conversionRate = 1.0;
                        break;
                    case 6: // CAD to YUAN
                        conversionRate = 5.22;
                        break;
                }
                break;
            case 6: // YUAN (Chinese Yuan)
                switch (targetCurrencyChoice) {
                    case 1: // YUAN to USD
                        conversionRate = 0.14;
                        break;
                    case 2: // YUAN to EUR
                        conversionRate = 0.12;
                        break;
                    case 3: // YUAN to INR
                        conversionRate = 11.69;
                        break;
                    case 4: // YUAN to YEN
                        conversionRate = 20.96;
                        break;
                    case 5: // YUAN to CAD
                        conversionRate = 0.19;
                        break;
                    case 6: // YUAN to YUAN
                        conversionRate = 1.0;
                        break;
                }
                break;
        }

        return amount * conversionRate;
    }
}