import java.util.Scanner;
public class PalindromeChecker {
    // Check whether a string is a palindrome
    static boolean isStringPalindrome(String text) {
        text = text.toLowerCase();
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // Check whether a number is a palindrome
    static boolean isNumberPalindrome(int number) {
        int originalNumber = number;
        int reverse = 0;
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }
        return originalNumber == reverse;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("================================");
            System.out.println("       PALINDROME CHECKER");
            System.out.println("================================");
            System.out.println("1. Check String Palindrome");
            System.out.println("2. Check Number Palindrome");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a string: ");
                    String text = scanner.nextLine();

                    if (isStringPalindrome(text)) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter a number: ");
                    int number = scanner.nextInt();

                    if (isNumberPalindrome(number)) {
                        System.out.println("The number is a palindrome.");
                    } else {
                        System.out.println("The number is not a palindrome.");
                    }
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
