import java.util.Scanner;

public class SimpleCalculator {

    public static float add(float a, float b) {
        return a + b;
    }

    public static float subtract(float a, float b) {
        return a - b;
    }

    public static float multiply(float a, float b) {
        return a * b;
    }

    public static float divide(float a, float b) {
        if (b == 0) {
            System.out.println("Error! Division by zero.");
            System.exit(1);
        }
        return a / b;
    }

    public static void main(String[] args) {
        float num1, num2, result = 0;
        char operator;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number:");
        num1 = input.nextFloat();

        System.out.println("operations(+, -, *, /):");
        operator = input.next().charAt(0);

        System.out.println("Enter second number:");
        num2 = input.nextFloat();

        switch(operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Error! Invalid operator");
                input.close();
                return;
        }
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        input.close();
    }
}
