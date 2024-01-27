package task5;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int Height, Width;

        System.out.println("Введите Height >= 1, Width >= 1");
        Height = readIntegerValueFromConsole("Height");
        Width = readIntegerValueFromConsole("Width");

        printFigure(Height, Width);
    }

    public static int readIntegerValueFromConsole(String varName) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("%s = ", varName);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (Exception e) {
                System.out.printf("  значение %s - некорректно!%n", line);
            }
        }
    }

    public static void printFigure(int Height, int Width) {
        for (int i = 0; i < Height; i++) {
            printSpaces(i);
            printSequenceDigits(Width - i);
            System.out.println();
        }
    }

    public static void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(' ');
        }
    }

    public static void printSequenceDigits(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i % 10);
        }
    }
}