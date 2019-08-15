package com.nishantkp.utils;

/**
 * UtilityManager contract class
 */
@SuppressWarnings("unused")
interface UtilityContract {

    /**
     * Use this method to save string preference
     */
    void putPreference(String key, String value);

    /**
     * Use this method to save integer preference
     */
    void putPreference(String key, int value);

    /**
     * Use this method to save boolean preference
     */
    void putPreference(String key, Boolean value);

    /**
     * Use this method to get string preference value
     */
    String getStringPreference(String key);

    /**
     * Use this method to get integer preference value
     */
    int getIntegerPreference(String key);

    /**
     * Use this method to get boolean preference value
     */
    Boolean getBooleanPreference(String key);

    /**
     * Use this method check whether the preference exists or not
     */
    Boolean containsPreference(String key);

    /**
     * Use this method to remove particular preference
     */
    void removePreference(String key);

    /**
     * Use this method to find out if the app is debuggable or not
     */
    boolean isAppDebuggable();
}
