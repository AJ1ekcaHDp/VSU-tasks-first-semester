package task2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        double A, B, C, W, H;
        Scanner scan = new Scanner(System.in);

        A = getSize("A", scan);
        B = getSize("B", scan);
        C = getSize("C", scan);
        W = getSize("W", scan);
        H = getSize("H", scan);

        boolean canPass = canBrickPass(A, B, C, W, H);

        displayResult(canPass);
    }

    public static double getSize(String sizeName, Scanner scan) {
        System.out.printf("Введите размер %s: ", sizeName);
        return scan.nextDouble();
    }

    public static boolean canBrickPass(double A, double B, double C, double W, double H) {
        double eps = 1e-10;
        double widthBrick = Math.min(Math.min(A, B), C);
        double lengthBrick = Math.max(Math.max(A, B), C);
        double heightBrick = (A + B + C) - lengthBrick - widthBrick;


        double widthHole = Math.min(W, H);
        double heightHole = Math.max(W, H);

        return ((widthHole + eps) - widthBrick) >= 0 && ((heightHole + eps) - heightBrick) >= 0;
    }

    public static void displayResult(boolean canPass) {
        if (canPass)
            System.out.println("Кирпич пройдёт в отверстие");
        else
            System.out.println("Кирпич не пройдёт в отверстие");
    }
}