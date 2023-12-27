import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers separated by space: ");

        String input = scanner.nextLine();

        String[] numbers = input.split("\\s+");

        double result = 0;
        boolean validInput = true;

        try {
            if (numbers.length > 1) {
                result = Double.parseDouble(numbers[0]);
                for (int i = 1; i < numbers.length; i += 2) {
                    String operator = numbers[i];
                    double num = Double.parseDouble(numbers[i + 1]);
                    switch (operator) {
                        case "+":
                            result += num;
                            break;
                        case "-":
                            result -= num;
                            break;
                        case "*":
                            result *= num;
                            break;
                        case "/":
                            if (num != 0) {
                                result /= num;
                            } else {
                                validInput = false;
                                System.out.println("Division by zero is not allowed.");
                            }
                            break;
                        default:
                            validInput = false;
                            System.out.println("Invalid operator.");
                            break;
                    }
                }
            } else {
                validInput = false;
            }
        } catch (NumberFormatException e) {
            validInput = false;
        }

        if (validInput) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid input. Please enter valid numbers and operators separated by space.");
        }

        scanner.close();
    }
}
