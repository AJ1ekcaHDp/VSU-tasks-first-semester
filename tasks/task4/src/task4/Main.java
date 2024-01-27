package task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double x, a, resultFirstEquation, resultSecondEquation;

        x = readDoubleValueFromConsole("x");
        a = readDoubleValueFromConsole("a");

        resultFirstEquation = solveFirstEquation(x);
        if (Double.isNaN(resultFirstEquation)) {
            System.out.println("Ошибка в первом уравнении: Деление на ноль.");
        } else {
            displayResult("первого", resultFirstEquation);
        }

        resultSecondEquation = solveSecondEquation(x, a);
        displayResult("второго", resultSecondEquation);
    }

    public static double readDoubleValueFromConsole(String varName) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Введите %s = ", varName);
            String line = scanner.nextLine();
            try {
                return Double.parseDouble(line);
            } catch (Exception e) {
                System.out.printf("  значение %s - некорректно!%n", line);
            }
        }
    }

    public static double solveFirstEquation(double x) {
        double numerator;
        double denominator;
        double y = 1.0;
        double epsilon = 1e-14;


        for (int i = 2; i <= 64; i += 2) {
            numerator = (x - i);
            denominator = (x - (i - 1));

            if (Math.abs(denominator) < epsilon) {
                return Double.NaN;
            }
            y *= numerator / denominator;
        }
        return y;
    }

    public static double solveSecondEquation(double x, double a) {
        double y = 1.0;

        for (int i = 1; i <= 6; i++) {
            y = y * x - a;
        }
        return y;
    }

    public static void displayResult(String functionName, double Result) {
        System.out.printf("Результат %s уравнения: %s%n", functionName, Result);
    }
}

