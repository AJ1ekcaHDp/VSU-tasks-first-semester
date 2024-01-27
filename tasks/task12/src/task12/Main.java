package task12;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n = ");
        int n = scanner.nextInt();

        char[][] a = Triangle.solution(n);
        Triangle.printArray(a);
    }
}