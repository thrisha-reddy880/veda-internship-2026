import java.util.Scanner;
abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();

    void displayResults() {
        System.out.printf("Area: %.2f%n", calculateArea());
        System.out.printf("Perimeter: %.2f%n", calculatePerimeter());
    }
}
class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
class Rectangle extends Shape {
    private final double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    double calculateArea() {
        return length * width;
    }
    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}
class Triangle extends Shape {
    private final double a;
    private final double b, c;
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override
    double calculatePerimeter() {
        return a + b + c;
    }
}
public class ShapeCalculator {
    public static void main(String[] args) {
        Shape shape = null;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("===== SHAPE CALCULATOR =====");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.print("Choose a shape: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter radius: ");
                    double radius = sc.nextDouble();

                    if (radius <= 0 || !Double.isFinite(radius)) {
                        System.out.println("Invalid radius!");
                    } else {
                        shape = new Circle(radius);
                    }
                }
                case 2 -> {
                    System.out.print("Enter length: ");
                    double length = sc.nextDouble();
                    System.out.print("Enter width: ");
                    double width = sc.nextDouble();

                    if (length <= 0 || width <= 0
                            || !Double.isFinite(length)
                            || !Double.isFinite(width)) {
                        System.out.println("Invalid dimensions!");
                    } else {
                        shape = new Rectangle(length, width);
                    }
                }
                case 3 -> {
                    System.out.print("Enter side A: ");
                    double a = sc.nextDouble();
                    System.out.print("Enter side B: ");
                    double b = sc.nextDouble();
                    System.out.print("Enter side C: ");
                    double c = sc.nextDouble();

                    if (!Double.isFinite(a) || !Double.isFinite(b)
                            || !Double.isFinite(c)
                            || a <= 0 || b <= 0 || c <= 0
                            || a + b <= c || a + c <= b || b + c <= a) {
                        System.out.println("Invalid triangle sides!");
                    } else {
                        shape = new Triangle(a, b, c);
                    }
                }
                default -> {
                    System.out.println("Invalid choice!");
                }
            }
            if (shape != null) {
                System.out.println("\n===== RESULTS =====");
                shape.displayResults();
            }
        }
    }
}
