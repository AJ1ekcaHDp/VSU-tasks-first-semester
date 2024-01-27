package task11;

import java.util.*;

public class Task {
    private static final List<String> ALPHABETS = Arrays.asList(
            "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ",
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "abcdefghijklmnopqrstuvwxyz"
    );

    public static int getPositionInAlphabet(char c, String alphabet) {
        int position = -1;
        int length = alphabet.length();
        for (int i = 0; i < length; i++) {
            if (c == alphabet.charAt(i)) {
                position = i;
            }
        }
        return position;
    }

    public static int getReversePosition(int position, String alphabet) {
        return alphabet.length() - 1 - position;
    }

    public static char getCharFromPosition(int position, String alphabet) {
        return alphabet.charAt(position);
    }


    public static char encodeChar(char c, List<String> abcs) {
        for (String alphabet : abcs) {
            int position = getPositionInAlphabet(c, alphabet);
            if (position != -1) {
                int reversePosition = getReversePosition(position, alphabet);
                return getCharFromPosition(reversePosition, alphabet);
            }
        }
        return c;
    }

    public static String encode(String text) {
        return encrypt(text, ALPHABETS);
    }

    public static String encrypt(String text, List<String> abc) {
        String encryptedText = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char encryptedChar = encodeChar(c, abc);
            encryptedText += encryptedChar;

        }
        return encryptedText;
    }
}

    /*
    private static final String RUSSIAN_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String LATIN_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(String text) {
        return transformText(text, getAlphabetMapping(RUSSIAN_ALPHABET), getAlphabetMapping(LATIN_ALPHABET));
    }

    private static Map<Character, Character> getAlphabetMapping(String alphabet) {
        Map<Character, Character> mapping = new HashMap<>();
        int length = alphabet.length();
        for (int i = 0; i < length; i++) {
            char currentChar = alphabet.charAt(i);
            char symmetricChar = alphabet.charAt(length - 1 - i);
            mapping.put(currentChar, symmetricChar);
            mapping.put(Character.toLowerCase(currentChar), Character.toLowerCase(symmetricChar));
        }
        return mapping;
    }
    private static String transformText(String text, Map<Character, Character> mapping1, Map<Character, Character> mapping2) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (mapping1.containsKey(c)) {
                result.append(mapping1.get(c));
            } else if (mapping2.containsKey(c)) {
                result.append(mapping2.get(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }*/