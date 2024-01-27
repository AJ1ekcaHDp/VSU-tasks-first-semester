package task7;

import task7.util.ArrayUtils;

public class Main {
    public static double calculateAverageValue(int[] array) {
        double sum = 0;

        for (int i : array) {
            sum += i;
        }
        return sum / array.length;
    }

    public static int solution(int[] array) {

        if (array == null) {
            return -1;
        }

        double minDifference = Double.POSITIVE_INFINITY;
        double averageValue = calculateAverageValue(array);
        final double EPSILON = 1e-14;
        int count = 0;

        for (int i : array) {
            double difference = Math.abs(averageValue - i);
            if (Math.abs(difference - minDifference) < EPSILON) {
                count++;
            } else if (difference < minDifference) {
                minDifference = difference;
                count = 1;
            }
        }
        return count;
    }


    public static void printResult(int[] intArray) {
        int result = solution(intArray);
        if (result == -1) {
            System.out.println("Массив не должен быть пустым");
        } else {
            System.out.printf("Количество элементов, максимально близких к среднему арифметическому: %d%n", result);
        }
    }

    public static void runTests() {
        int[][] testsInput = {
                {1, 4, 2, 5, 8, 4, 1, 3},
                {},
                {9},
                {1, 2, 3, 4, 5},
                {-5, -2, 0, 2, 5},
                {-3, -1, -2, -5, -8, -4, -1, -3},
                {1, 1, 1, 1, 1},
                {10, 5, 8, 12, 15, 9, 11},
                {10, 20, 30, 40, 50},
                {9, 7, 5, 3, 1},
                {Integer.MAX_VALUE, -100, 100, Integer.MIN_VALUE},
        };

        for (int[] testInput : testsInput) {
            System.out.println("Массив: " + ArrayUtils.toString(testInput));
            printResult(testInput);
            System.out.println("-".repeat(40));
        }
    }

    public static void main(String[] args) {
        runTests();

        String arrayName = "numbers";
        int[] intArray = ArrayUtils.readIntArrayFromConsole(arrayName);
        printResult(intArray);
    }
}