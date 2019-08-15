package com.nishantkp.utils;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import androidx.fragment.app.Fragment;

import java.io.Serializable;

/**
 * This class will print the log messages only if the app is in debug mode
 * <p>
 * NOTE : TO USE THIS LOGS YOU MUST INITIALIZE {@link UtilityManager} IN APPLICATION CLASS
 */
@SuppressWarnings("unused")
public final class Logger implements Serializable {

    /**
     * LogUtils with unique identifier
     * i -> Info log
     *
     * @param clazz class instance
     * @param id    unique id which easily distinguish log from rest of logs
     * @param m     your log message
     */
    public static void i(Class clazz, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.i(clazz.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * i -> Info log
     *
     * @param ac activity instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void i(Activity ac, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            Log.i(ac.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * i -> Info log
     *
     * @param app application class instance
     * @param id  unique id which easily distinguish log from rest of logs
     * @param m   your log message
     */
    public static void i(Application app, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.i(app.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * i -> Info log
     *
     * @param fr class instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void i(Fragment fr, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.i(fr.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * i -> Info log
     *
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void i(String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.i(Logger.class.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * Just print info log message
     * i -> Info log
     *
     * @param m your log message
     */
    public static void i(String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.i(Logger.class.getSimpleName(), m);
        }
    }

    /**
     * LogUtils with unique identifier
     * d -> Debug log
     *
     * @param clazz class instance
     * @param id    unique id which easily distinguish log from rest of logs
     * @param m     your log message
     */
    public static void d(Class clazz, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.d(clazz.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * d -> Debug log
     *
     * @param ac activity instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void d(Activity ac, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.d(ac.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * d -> Debug log
     *
     * @param app application class instance
     * @param id  unique id which easily distinguish log from rest of logs
     * @param m   your log message
     */
    public static void d(Application app, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.d(app.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * d -> Debug log
     *
     * @param fr class instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void d(Fragment fr, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.d(fr.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * d -> Debug log
     *
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void d(String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.d(Logger.class.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * Just print debug level log message
     *
     * @param m your log message
     */
    public static void d(String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.d(Logger.class.getSimpleName(), m);
        }
    }

    /**
     * LogUtils with unique identifier
     * e -> Error log
     *
     * @param clazz class instance
     * @param id    unique id which easily distinguish log from rest of logs
     * @param m     your log message
     */
    public static void e(Class clazz, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.e(clazz.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * e -> Error log
     *
     * @param ac activity instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void e(Activity ac, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            Log.e(ac.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * e -> Error log
     *
     * @param app application class instance
     * @param id  unique id which easily distinguish log from rest of logs
     * @param m   your log message
     */
    public static void e(Application app, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.e(app.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * e -> Error log
     *
     * @param fr class instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void e(Fragment fr, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.i(fr.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * e -> Error log
     *
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void e(String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.e(Logger.class.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * Just print error level log message
     * e -> Error log
     *
     * @param m your log message
     */
    public static void e(String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.e(Logger.class.getSimpleName(), m);
        }
    }

    /**
     * LogUtils with unique identifier
     * w -> Warning log
     *
     * @param clazz class instance
     * @param id    unique id which easily distinguish log from rest of logs
     * @param m     your log message
     */
    public static void w(Class clazz, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.w(clazz.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * w -> Warning log
     *
     * @param ac activity instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void w(Activity ac, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            Log.w(ac.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * w -> Warning log
     *
     * @param app application class instance
     * @param id  unique id which easily distinguish log from rest of logs
     * @param m   your log message
     */
    public static void w(Application app, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.w(app.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * w -> Warning log
     *
     * @param fr class instance
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void w(Fragment fr, String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.w(fr.getClass().getSimpleName(), id + " : " + m);
        }
    }

    /**
     * LogUtils with unique identifier
     * w -> Warning log
     *
     * @param id unique id which easily distinguish log from rest of logs
     * @param m  your log message
     */
    public static void w(String id, String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.w(Logger.class.getSimpleName(), id + " : " + m);
        }
    }

    /**
     * Just print info warning level log message
     * w -> Warning log
     *
     * @param m your log message
     */
    public static void w(String m) {
        if (UtilityManager.getInstance().isAppDebuggable()) {
            android.util.Log.w(Logger.class.getSimpleName(), m);
        }
    }
}
