package com.nishantkp.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * UtilityManager deals with all the network related and database related operations
 * <p>
 * Prerequisites : Initialize {@link UtilityManager} with {@link UtilityManager#Initialize(Context)}
 * in {@link android.app.Application} class, and then use {@link UtilityManager#getInstance()} to
 * get instance of {@link UtilityManager}
 * <p>
 * i.e,
 * <pre><{@code
 *          // Subclass the application class
 *          public class MyCustomApplication extends Application {
 *
 *              @Override
 *                public void onCreate() {
 * 	                super.onCreate();
 *                  UtilityManager.Initialize(this);
 *              }
 *          }
 *      }
 * </pre>
 */
@SuppressWarnings("unused")
public class UtilityManager implements Serializable, UtilityContract {

    private static volatile UtilityManager sUtilityManager;
    private static boolean sIsAppDebuggable;
    private PreferenceUseCase mPreferenceUseCase;

    /**
     * Private constructor, so no one can make direct instance of UtilityManager
     *
     * @param context context
     */
    private UtilityManager(Context context) {

        //Prevent form the reflection api.
        if (sUtilityManager != null) {
            throw new RuntimeException("Use getInstance() to get the single instance of " +
                    "UtilityManager");
        }

        mPreferenceUseCase = new PreferenceUseCase(context);
        sIsAppDebuggable = ((context.getApplicationInfo().flags
                & ApplicationInfo.FLAG_DEBUGGABLE) != 0);
    }

    /**
     * This will create a single-ton
     *
     * @param context Context
     */
    public static void Initialize(@NonNull Context context) {
        if (sUtilityManager == null) {
            synchronized (UtilityManager.class) {
                if (sUtilityManager == null) {
                    sUtilityManager = new UtilityManager(context);
                }
            }
        }
    }

    /**
     * Use this method to get the {@link UtilityManager} instance
     *
     * @return {@link UtilityManager} instance
     */
    public static UtilityManager getInstance() {
        // Null check
        if (sUtilityManager == null) {
            throw new RuntimeException("Use UtilityManager.Initialize(Context) to get the single " +
                    "instance of initialize UtilityManager and then use getInstance() to get the " +
                    "single instance of UtilityManager");
        }
        return sUtilityManager;
    }

    /**
     * Make singleton from serializable and deserialization operation
     *
     * @return The {@link UtilityManager} instance
     */
    protected UtilityManager readResolve() {
        return getInstance();
    }

    /**
     * Use this method to store string to the preferences
     *
     * @param key   Preference key
     * @param value value
     */
    @Override
    public void putPreference(String key, String value) {
        mPreferenceUseCase.putString(key, value);
    }

    /**
     * Use this method to store boolean to the preferences
     *
     * @param key   Preference key
     * @param value value
     */
    @Override
    public void putPreference(String key, int value) {
        mPreferenceUseCase.putInt(key, value);
    }

    /**
     * Use this method to store integer to the preferences
     *
     * @param key   Preference key
     * @param value value
     */
    @Override
    public void putPreference(String key, Boolean value) {
        mPreferenceUseCase.putBoolean(key, value);
    }

    /**
     * Use this method to get the string from the preference based on key
     *
     * @param key Preference key
     * @return if the preference is present it will return it's value and if there is no
     * preference with specified key, it will return null
     */
    @Override
    public String getStringPreference(String key) {
        return mPreferenceUseCase.getString(key);
    }

    /**
     * Use this method to get the string from the preference based on key
     *
     * @param key Preference key
     * @return if the preference is present it will return it's value and if there is no
     * preference with specified key,  it will return {@link Integer#MAX_VALUE}
     */
    @Override
    public int getIntegerPreference(String key) {
        return mPreferenceUseCase.getInt(key);
    }

    /**
     * Use this method to get the boolean from the preference based on key
     *
     * @param key Preference key
     * @return if the preference is present it will return it's value and if there is no
     * preference with specified key, it will return false
     */
    @Override
    public Boolean getBooleanPreference(String key) {
        return mPreferenceUseCase.getBoolean(key);
    }

    /**
     * Use this method to check if the preference is exists or not
     *
     * @param key Preference key
     * @return true if the preference is exists and false is not
     */
    @Override
    public Boolean containsPreference(String key) {
        return mPreferenceUseCase.contains(key);
    }

    /**
     * Use this method to remove preference specified by it's key
     *
     * @param key Preference key
     */
    @Override
    public void removePreference(String key) {
        mPreferenceUseCase.remove(key);
    }

    /**
     * Use this method to find out if the app is debuggable or not
     *
     * @return true or false
     */
    @Override
    public boolean isAppDebuggable() {
        return sIsAppDebuggable;
    }
}
