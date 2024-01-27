package task9;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task {
    public static List<Integer> createNewList(List<Integer> list, int n) {
        if (n <= 0) {
            System.out.println("Значение n должно быть больше 0");
            return new ArrayList<>();
        }
        List<Integer> newList = new ArrayList<>();

        int minValue = findFirstMinElement(list);
        newList.add(minValue);

        for (int i = 1; i < n; i++) {
            int minValueIndex = findNextMinValue(list, minValue);
            if (minValueIndex == -1) {
                break;
            }
            minValue = list.get(minValueIndex);
            newList.add(minValue);
        }
        return newList;
    }

    public static int findFirstMinElement(List<Integer> list) {
        int firstMin = list.get(0);
        for (int num : list) {
            if (num < firstMin) {
                firstMin = num;
            }
        }
        return firstMin;
    }

    public static boolean containsMaxValue(List<Integer> list) {
        for (int value : list) {
            if (value == Integer.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    public static int findNextMinValue(List<Integer> list, int minValue) {
        int nextMinValueIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > minValue &&
                    (nextMinValueIndex == -1 || list.get(i) < list.get(nextMinValueIndex))) {
                nextMinValueIndex = i;
            }
        }
        return nextMinValueIndex;
    }
    /* Другое решение
    public static List<Integer> createNewList(List<Integer> list, int n) {
        if (n <= 0) {
            System.out.println("Значение n должно быть больше 0");
            return new ArrayList<>();
        }
        List<Integer> result = uniqValues(list);
        result = sortAscending(result);
        result = limitSize(result, n);
        return result; // можно заменить одной строкой return limitSize(sortAscending(uniqValues(list)), n); ?
    }

    public static List<Integer> uniqValues(List<Integer> list) {
        List<Integer> uniqValuesList = new ArrayList<>();
        Set<Integer> uniq = new HashSet<>();
        for (Integer v : list) {
            if (!uniq.contains(v)) {
                uniqValuesList.add(v);
                uniq.add(v);
            }
        }
        return uniqValuesList;
    }

    public static List<Integer> sortAscending(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    public static List<Integer> limitSize(List<Integer> list, int n) {
        List<Integer> limitedList = new ArrayList<>();
        int listSize = Math.min(n, list.size());
        for (Integer v : list) {
            limitedList.add(v);
            if (limitedList.size() == listSize) {
                break;
            }
        }
        return limitedList;
    }*/
}
