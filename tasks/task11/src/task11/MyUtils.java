package task11;

import javax.swing.*;

public class MyUtils {
    public static void writeStringArrayToEditorPane (JEditorPane field, String[] text){
        StringBuilder string = new StringBuilder();
        for (String str : text){
            string.append(str).append("\n");
        }
        field.setText(new String(string));
    }

    public static String stringArrayToString(String[] stringArray) {
        StringBuilder string = new StringBuilder();
        for (String i : stringArray) {
            string.append(i).append("\n");
        }
        return new String(string);
    }
}
