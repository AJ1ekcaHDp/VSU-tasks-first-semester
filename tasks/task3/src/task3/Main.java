package task3;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final HorizontalParabola P1 = new HorizontalParabola(-6, -5, -0.5);
    public static final VerticalParabola P2 = new VerticalParabola(4, -2, 0.25);
    public static final VerticalParabola P3 = new VerticalParabola(0, 5, -0.25);
    public static final Circle C1 = new Circle(0, 2, 2);

    public static SimpleColor getColor(double x, double y) {
        if (C1.isPointInsideCircle(x, y)) {
            return P2.isPointUpOfParabola(x, y) ? SimpleColor.GRAY : SimpleColor.BLUE;
        }
        if (!P1.isPointRightOfParabola(x, y)) {
            return P3.isPointUpOfParabola(x, y) ? SimpleColor.GREEN : SimpleColor.ORANGE;
        }
        if (P2.isPointUpOfParabola(x, y)) {
            return P3.isPointUpOfParabola(x, y) ? SimpleColor.YELLOW : SimpleColor.BLUE;
        }
        if (P3.isPointUpOfParabola(x, y) && x < 0) {
            return (y > -5) ? SimpleColor.GREEN : SimpleColor.ORANGE;
        }
        return SimpleColor.YELLOW;
    }

    public static void printColorForPoint(double x, double y) {
        System.out.printf("(%.3f, %.3f) -> %s%n", x, y, getColor(x, y));
    }

    public static void tests() {
        printColorForPoint(1, 2);
        printColorForPoint(-1, 2);
        printColorForPoint(3, 1);
        printColorForPoint(5, 1);
        printColorForPoint(1, -1);
        printColorForPoint(8, -2);
        printColorForPoint(-6.1, -5);
        printColorForPoint(-9, -9);
        printColorForPoint(-7, -5);
        printColorForPoint(-6, -2);
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
