package com.nishantkp.utils;

import android.app.Activity;
import android.app.Application;

import androidx.fragment.app.Fragment;

/**
 * This class will print the log messages
 */
public final class LogUtils {

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param clazz class instance
     * @param id    unique id which easily distinguish log from rest of logs
     * @param m     your log message
     */
    public static void i(Class clazz, String id, String m) {
        android.util.Log.i(clazz.getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param ac activity instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void i(Activity ac, String id, String m) {
        android.util.Log.i(ac.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param app application class instance
     * @param id  unique id which easily distinguish log from rest of logs
     * @param m   your log message
     */
    public static void i(Application app, String id, String m) {
        android.util.Log.i(app.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param fr class instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void i(Fragment fr, String id, String m) {
        android.util.Log.i(fr.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void i(String id, String m) {
        android.util.Log.i(LogUtils.class.getSimpleName(), id + " : " + m);
    }

    /**
     * Just print the log message
     *
     * @param m your log message
     */
    public static void just(String m) {
        android.util.Log.i(LogUtils.class.getSimpleName(), m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param clazz class instance
     * @param id    unique id which easily distinguish log from rest of logs
     * @param m     your log message
     */
    public static void d(Class clazz, String id, String m) {
        android.util.Log.d(clazz.getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param ac activity instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void d(Activity ac, String id, String m) {
        android.util.Log.d(ac.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param app application class instance
     * @param id  unique id which easily distinguish log from rest of logs
     * @param m   your log message
     */
    public static void d(Application app, String id, String m) {
        android.util.Log.d(app.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param fr class instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void d(Fragment fr, String id, String m) {
        android.util.Log.d(fr.getClass().getSimpleName(), id + " : " + m);
    }

    /**
     * LogUtils with unique identifier
     * ui -> Unique Identifier
     *
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void d(String id, String m) {
        android.util.Log.d(LogUtils.class.getSimpleName(), id + " : " + m);
    }
}
