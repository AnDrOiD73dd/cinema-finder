package com.ateam.zuml.cinemafinder.enums;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotatedMovieStatus {
    public static final String RUMORED = "RUMORED";
    public static final String PLANNED = "PLANNED";
    public static final String IN_PRODUCTION = "IN_PRODUCTION";
    public static final String POST_PRODUCTION = "POST_PRODUCTION";
    public static final String RELEASED = "RELEASED";
    public static final String CANCELED = "CANCELED";

    @StringDef({RUMORED, PLANNED, IN_PRODUCTION, POST_PRODUCTION, RELEASED, CANCELED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MovieStatus {}
}
