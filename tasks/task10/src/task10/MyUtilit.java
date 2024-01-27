package task10;

import java.util.ArrayList;
import java.util.List;

public class MyUtilit {
    public static List<Segment> convertIntArrayToSegmentList(int[][] arr) {
        List<Segment> segmentList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            segmentList.add(new Segment(start, end));
        }
        return segmentList;
    }

    public static int[][] convertSegmentListToIntArray(List<Segment> segmentList) {
        int[][] matrix = new int[segmentList.size()][2];
        for (int i = 0; i < segmentList.size(); i++){
            matrix[i][0] = segmentList.get(i).getStart();
            matrix[i][1] = segmentList.get(i).getEnd();
        }
        return matrix;
    }
}
