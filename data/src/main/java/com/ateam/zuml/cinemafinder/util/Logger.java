package com.ateam.zuml.cinemafinder.util;

import android.util.Log;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Logger {

    private String appTag;
    private boolean printFileName;

    @Inject
    public Logger(String appTag, boolean printFileName) {
        this.appTag = appTag;
        this.printFileName = printFileName;
    }

    private void vt(String tag, String message) {
        StringBuilder sb = getStringBuilder(message);
        Log.v(tag, sb.toString());
    }

    private void dt(String tag, String message) {
        StringBuilder sb = getStringBuilder(message);
        Log.d(tag, sb.toString());
    }

    private void it(String tag, String message) {
        StringBuilder sb = getStringBuilder(message);
        Log.i(tag, sb.toString());
    }

    private void wt(String tag, String message) {
        StringBuilder sb = getStringBuilder(message);
        Log.w(tag, sb.toString());
    }


    private void et(String tag, String message) {
        StringBuilder sb = getStringBuilder(message);
        Log.e(tag, sb.toString());
    }


    private void et(String tag, Throwable e) {
        Log.e(tag, "Exception: ", e);
    }

    public void e(Throwable e) {
        et(appTag, e);
    }

    public void v(String format, Object... args) {
        vt(appTag, String.format(Locale.getDefault(), format, args));
    }

    public void d(String format, Object... args) {
        dt(appTag, String.format(Locale.getDefault(), format, args));
    }

    public void i(String format, Object... args) {
        it(appTag, String.format(Locale.getDefault(), format, args));
    }

    public void w(String format, Object... args) {
        wt(appTag, String.format(Locale.getDefault(), format, args));
    }

    public void e(String format, Object... args) {
        et(appTag, String.format(Locale.getDefault(), format, args));
    }


    private StringBuilder getStringBuilder(String message) {
        return new StringBuilder(100).append(getLocation()).append(' ').append(message);
    }

    private String getLocation() {
        if (!printFileName) {
            return "";
        }

        final String logClassName = Logger.class.getName();
        final StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        boolean found = false;

        for (StackTraceElement trace : traces) {
            if (found) {
                if (!trace.getClassName().startsWith(logClassName)) {
                    String className = trace.getFileName().substring(0, trace.getFileName().length() - 5);
                    return String.format(Locale.getDefault(), "[%s.%s:%d]", className, trace.getMethodName(), trace.getLineNumber());
                }
            } else if (trace.getClassName().startsWith(logClassName)) {
                found = true;
            }
        }
        return "[]";
    }

}
