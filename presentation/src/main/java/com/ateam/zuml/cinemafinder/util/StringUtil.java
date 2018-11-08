package com.ateam.zuml.cinemafinder.util;

public final class StringUtil {

    public StringUtil() {
    }

    public String getStringFromArrayGenres(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (arr.length == 1 || i == (arr.length - 1)) {
                break;
            }
            sb.append(", ");
        }

        return sb.toString();
    }

    public String addBrackets(String s) {
        return "(" + s + ")";
    }

    public String getStabUrl() {
        return "-";
    }
}
