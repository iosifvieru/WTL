package org.L02.utils;

public class TextSanitizer {
    public static String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("%", "");
    }
}
