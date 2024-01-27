package task6;

public class Solution {
    public static double idealExpMinusX(double x) {
        return Math.exp(-x);
    }

    public static double expMinusXN(double x, int n) {
        double sum = 1.0;
        double term = 1.0;
        for (int i = 1; i < n; i++) {
            term = -term * x / i;
            sum += term;
        }
        return sum;
    }

    public static Result expMinusXE(double x, double eps) {
        double sum = 1.0;
        double term = 1.0;
        int i = 1;
        while (Math.abs(term) > eps) {
            term = -term * x / i;
            sum += term;
            i++;
        }
        return new Result(sum, i);
    }
}
