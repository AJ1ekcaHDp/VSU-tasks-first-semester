package task10;

import java.util.*;

public class Task {
    public static void sortSegments(List<Segment> segments) {
        for (int i = 0; i < segments.size(); i++) {
            for (int j = i + 1; j < segments.size(); j++) {
                if (compareSegments(segments.get(i), segments.get(j)) > 0) {
                    Segment temp = segments.get(i);
                    segments.set(i, segments.get(j));
                    segments.set(j, temp);
                }
            }
        }
    }

    public static int compareSegments(Segment segment1, Segment segment2) {
        if (segment1.getStart() < segment2.getStart()) {
            return -1;
        } else if (segment1.getStart() > segment2.getStart()) {
            return 1;
        } else {
            if (segment1.getEnd() < segment2.getEnd()) {
                return -1;
            } else if (segment1.getEnd() > segment2.getEnd()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static List<Segment> uniteSegments(List<Segment> segments) {
        List<Segment> result = new ArrayList<>();

        Segment selectedSegment = segments.get(0).createCopy();

        for (int i = 1; i < segments.size(); i++) {
            Segment nextSegment = segments.get(i);
            if (selectedSegment.getEnd() >= nextSegment.getStart()) {
                selectedSegment.setEnd(Math.max(selectedSegment.getEnd(), nextSegment.getEnd()));
            } else {
                result.add(selectedSegment);
                selectedSegment = new Segment(nextSegment); //аналог моего - nextSegment.createCopy();
            }
        }

        result.add(selectedSegment);
        return result;
    }

    public static List<Segment> solution(List<Segment> segments) {
        if (segments == null)
            return null;
        if (segments.size() == 0)
            return new ArrayList<>();

        sortSegments(segments);
        List<Segment> result = uniteSegments(segments);

        return result;
    }
}
