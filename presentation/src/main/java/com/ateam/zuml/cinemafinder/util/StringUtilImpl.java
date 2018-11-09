package com.ateam.zuml.cinemafinder.util;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class StringUtilImpl implements StringUtils{

    @Inject
    StringUtilImpl() {
    }

    @Override
    public String getStringFromArrayGenres(final String[] arr) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (arr.length == 1 || i == (arr.length - 1)) {
                break;
            }
            sb.append(", ");
        }

        return sb.toString();
    }

    @Override
    public String addBrackets(final String s) {
        return "(" + s + ")";
    }
}
