package task5_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение s (s должно быть >= 2 и четным): ");

        int s = scanner.nextInt();
        if (s >= 2 && s % 2 == 0) {
            printUpperPart(s);
            printLowerPart(s);
        } else {
            System.out.println("Ошибка: s должно быть >= 2 и четным.");
        }
    }

    public static void printUpperPart(int s) {
        for (int i = 0; i < s / 2; i++) {
            printSpaces(s / 2 - (1 + i));
            printDigitsAscending(i);
            System.out.println();
        }
    }

    public static void printLowerPart(int s) {
        for (int i = s / 2; i > 0; i--) {
            printSpaces(s / 2);
            printDigitsDescending(i - 1);
            System.out.println();
        }
    }


    public static void printSpaces(int numberSpaces) {
        for (int j = 0; j < numberSpaces; j++) {
            System.out.print(" ");
        }
    }

    public static void printDigitsDescending(int endDigit) {
        for (int j = endDigit; j >= 0; j--) {
            System.out.print(j % 10);
        }
    }


    public static void printDigitsAscending(int endDigit) {
        for (int j = 0; j <= endDigit; j++) {
            System.out.print(j % 10);
        }
    }
}