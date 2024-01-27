package task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputAndOutput {
    public static List<Integer> readListFromFile(String inputFile) {
        File file = new File(inputFile);
        List<Integer> introducedList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("(\\s|[,;])+");
            while (scanner.hasNextInt()) {
                introducedList.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + inputFile);
            System.exit(2);
        }

        return introducedList;
    }
    public static void saveFile(List<Integer> answerList, String outputFile) {
        try {
            File file = new File(outputFile);
            PrintWriter write = new PrintWriter(file);
            for (Integer value : answerList) {
                if (!value.equals(answerList.get(answerList.size() - 1))) {
                    write.print(value + ", ");
                } else {
                    write.print(value);
                }
            }
            write.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + outputFile);
            System.exit(2);
        }
    }

}
