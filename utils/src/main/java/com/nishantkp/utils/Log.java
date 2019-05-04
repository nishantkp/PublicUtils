package com.nishantkp.utils;

import android.app.Activity;
import android.app.Application;

import androidx.fragment.app.Fragment;

/**
 * This class will print the log messages
 */
public final class Log {

    /**
     * Log with unique identifier
     * ui -> Unique Identifier
     *
     * @param clazz class instance
     * @param id    unique id which easily distinguish log from rest of logs
     * @param m     your log message
     */
    public static void ui(Class clazz, String id, String m) {
        android.util.Log.i(clazz.getSimpleName(), id + " : " + m);
    }

    /**
     * Log with unique identifier
     * ui -> Unique Identifier
     *
     * @param ac activity instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void ui(Activity ac, String id, String m) {
        android.util.Log.i(ac.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * Log with unique identifier
     * ui -> Unique Identifier
     *
     * @param app application class instance
     * @param id  unique id which easily distinguish log from rest of logs
     * @param m   your log message
     */
    public static void ui(Application app, String id, String m) {
        android.util.Log.i(app.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * Log with unique identifier
     * ui -> Unique Identifier
     *
     * @param fr class instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void ui(Fragment fr, String id, String m) {
        android.util.Log.i(fr.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * Log with unique identifier
     * ui -> Unique Identifier
     *
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void ui(String id, String m) {
        android.util.Log.i(Log.class.getSimpleName(), id + " : " + m);
    }

    /**
     * Just print the log message
     *
     * @param m your log message
     */
    public static void just(String m) {
        android.util.Log.i(Log.class.getSimpleName(), m);
    }
}
