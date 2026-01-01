import java.util.Scanner;

public class Main {

    private static ArithmeticOperation arithmeticOperation;
    Main(ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Choose operation (+), (-), (*), (-): ");
            char opera = scanner.next().charAt(0);

            double result;

            switch (opera) {
                case '+':
                    result = arithmeticOperation.add(num1, num2);
                    break;
                case '-':
                    result = arithmeticOperation.subtract(num1, num2);
                    break;
                case '*':
                    result = arithmeticOperation.multiply(num1, num2);
                    break;
                case '/':
                    result = arithmeticOperation.divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operation selected.");
                    return;
            }

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
