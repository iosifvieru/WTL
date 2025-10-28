package org.example;

public class Utils {
    public static String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot")
                .replaceAll("&", "&amp;");
    }
}
