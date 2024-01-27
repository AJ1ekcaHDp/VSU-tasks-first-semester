package task6;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = scan.nextDouble();
        System.out.print("Enter n: ");
        int n = scan.nextInt();
        System.out.print("Enter epsilon: ");
        double eps = scan.nextDouble();

        double ideal = Solution.idealExpMinusX(x);
        double resultN = Solution.expMinusXN(x, n);
        double deltaN = Math.abs(resultN - ideal);
        Result rE = Solution.expMinusXE(x, eps);
        double deltaE = Math.abs(rE.getSum() - ideal);
        Result rE10 = Solution.expMinusXE(x, eps * 0.1);
        double deltaE10 = Math.abs(rE.getSum() - ideal);

        System.out.printf("Ideal : %.15f\n", ideal);
        System.out.printf("expMinusXN  : %.15f; delta=%e\n", resultN, deltaN);
        System.out.printf("expMinusXE  : %.15f; delta=%e; count=%d\n", rE.getSum(), deltaE, rE.getCount());
        System.out.printf("expMinusXE10: %.15f; delta=%e; count=%d\n", rE10.getSum(), deltaE10, rE10.getCount());
    }
}
