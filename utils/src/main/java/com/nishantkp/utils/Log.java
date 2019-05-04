package com.nishantkp.utils;

/**
 * This class will print the log messages
 */
public class Log {

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
