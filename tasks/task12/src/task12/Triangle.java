package task12;

import java.util.Arrays;

public class Triangle {
    public static void emptyArray(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            Arrays.fill(a[i], ' ');
        }
    }

    public static void createTriangle(char[][] a, int n, int x, int y, int size) {
        if (n < 1) {
            return;
        }
        if (n == 1) {
            a[x][y] = a[x + 1][y - 1] = '/';
            a[x][y + 1] = a[x + 1][y + 2] = '\\';
            a[x + 1][y] = a[x + 1][y + 1] = '_';
        } else {
            createTriangle(a, n - 1, x, y, size / 2);
            createTriangle(a, n - 1, x + size, y - size, size / 2);
            createTriangle(a, n - 1, x + size, y + size, size / 2);
        }
    }

    public static void printArray(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] solution(int n) {
        char[][] a = createMatrix(n);
        emptyArray(a);
        createTriangle(a, n, 0, a[0].length / 2 - 1, a.length / 2);
        return a;
    }

    public static char[][] createMatrix(int n) {
        int row = 1 << n; //битовый сдвиг, аналог (int) Math.pow(2, n);
        int column = row * 2;
        char[][] a = new char[row][column];
        return a;
    }
}
