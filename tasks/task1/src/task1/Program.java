package task1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double lengthSquare = getSquareLength(scan);
        double shadedArea = calculateShadedArea(lengthSquare);

        displayResult(shadedArea);
    }

    public static double getSquareLength(Scanner scan) {
        System.out.print("Введите длину стороны квадрата: ");
        return scan.nextDouble();
    }

    public static double calculateSquareArea(double lengthSquare) {
        return lengthSquare * lengthSquare;
    }

    public static double calculateCircleArea(double lengthSquare) {
        return (Math.PI * lengthSquare * lengthSquare) / 4.0;
    }

    public static double calculateShadedArea(double lengthSquare) {
        return (calculateSquareArea(lengthSquare) + calculateCircleArea(lengthSquare)) / 2.0;
    }

    public static void displayResult(double shadedArea) {
        System.out.println("Площадь заштрихованной фигуры: " + shadedArea);
    }
}