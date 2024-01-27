package task3_1;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final HorizontalParabola P1 = new HorizontalParabola(4, 5, 1);
    public static final VerticalParabola P2 = new VerticalParabola(6, -2, 0.125);
    public static final Circle C1 = new Circle(-3, 7, 5);
    public static final Square S1 = new Square(-6, 2, 3, 7);


    public static SimpleColor getColor(double x, double y) {
        if (P1.isPointRightOfParabola(x, y)) {
            return SimpleColor.WHITE;
        }
        if (!C1.isPointInCircle(x, y) && !P2.isPointUpOfParabola(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (P2.isPointUpOfParabola(x, y) && !P1.isPointRightOfParabola(x, y) && !C1.isPointInCircle(x, y) && !S1.isPointInSquare(x, y)) {
            return SimpleColor.YELLOW;
        }
        if (C1.isPointInCircle(x, y) && P2.isPointUpOfParabola(x, y)) {
            if (S1.isPointInSquare(x, y)) {
                return SimpleColor.BLUE;
            } else {
                return SimpleColor.WHITE;
            }
        }
        if (S1.isPointInSquare(x, y)) {
            if (C1.isPointInCircle(x, y)) {
                return SimpleColor.WHITE;
            } else {
                return SimpleColor.GREEN;
            }
        }
        if (C1.isPointInCircle(x, y) && !S1.isPointInSquare(x, y)) {
            if (y > 3) {
                return SimpleColor.BLUE;
            } else {
                return SimpleColor.GREEN;
            }
        }
        return SimpleColor.NAN;
    }

    public static void printColorForPoint(double x, double y) {
        System.out.printf("(%.3f, %.3f) -> %s%n", x, y, getColor(x, y));
    }

    public static void tests() {
        printColorForPoint(5, 5);
        printColorForPoint(0, 2);
        printColorForPoint(6, 0);
        printColorForPoint(0, 4);
        printColorForPoint(0, 8);
        printColorForPoint(1, 3.5);
        printColorForPoint(-2, 4);
        printColorForPoint(-3, 2.5);
        printColorForPoint(-7, 5);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        tests();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input x, y: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        printColorForPoint(x, y);
    }
}
