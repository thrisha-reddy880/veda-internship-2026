import java.util.Scanner;
interface PaymentMethod {
    void pay(double amount);
}
class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("Payment of Rs. %.2f processed using Card.%n", amount);
    }
}
class UPIPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.printf("Payment of Rs. %.2f processed using UPI.%n", amount);
    }
}
class WalletPayment implements PaymentMethod {
    private double balance = 5000.00;
    @Override
    public void pay(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient wallet balance!");
        } else {
            balance -= amount;
            System.out.printf("Payment of Rs. %.2f processed using Wallet.%n", amount);
            System.out.printf("Remaining wallet balance: Rs. %.2f%n", balance);
        }
    }
}
public class PaymentSystem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
        System.out.println("===== PAYMENT SYSTEM =====");
        System.out.println("1. Card Payment");
        System.out.println("2. UPI Payment");
        System.out.println("3. Wallet Payment");
        System.out.print("Choose payment method: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid choice!");
            return;
        }
        int choice = sc.nextInt();
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid payment method!");
            return;
        }
        System.out.print("Enter payment amount: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid amount!");
            return;
        }
        double amount = sc.nextDouble();
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Amount must be greater than zero!");
            return;
        }
        PaymentMethod payment = switch (choice) {
            case 1 -> new CardPayment();
            case 2 -> new UPIPayment();
            default -> new WalletPayment();
        };
        payment.pay(amount);
        }
    }
}
