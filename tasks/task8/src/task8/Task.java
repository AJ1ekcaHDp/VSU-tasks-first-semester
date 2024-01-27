package task8;


public class Task {
    public static void shiftInRow(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    public static void shiftRow(int[][] arr) {
        int[] temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
    public static void cyclicDiagonalShift(int[][] arr, int n) {
        for (int k = 0; k < (n % arr[0].length); k++) {
            for (int i = 0; i < arr.length; i++) {
                shiftInRow(arr[i]);
            }
            shiftRow(arr);
        }
    }
}
