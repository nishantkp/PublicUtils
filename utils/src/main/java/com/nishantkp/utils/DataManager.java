package com.nishantkp.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * DataManager deals with all the network related and database related operations
 * <p>
 * Prerequisites : Initialize {@link DataManager} with {@link DataManager#Initialize(Context)}
 * in {@link android.app.Application} class, and then use {@link DataManager#getInstance()} to get
 * instance of {@link DataManager}
 * <p>
 * i.e,
 * <pre><{@code
 *          // Subclass the application class
 *          public class MyCustomApplication extends Application {
 *
 *              @Override
 * 	            public void onCreate() {
 * 	                super.onCreate();
 *                  DataManager.Initialize(this);
 *              }
 *          }
 *      }
 * </pre>
 */
public class DataManager implements Serializable, DataContract {

    private static volatile DataManager sDataManager;
    private PreferenceUseCase mPreferenceUseCase;

    /**
     * Private constructor, so no one can make direct instance of DataManager
     *
     * @param context context
     */
    private DataManager(Context context) {

        //Prevent form the reflection api.
        if (sDataManager != null) {
            throw new RuntimeException("Use getInstance() to get the single instance of " +
                    "DataManager");
        }

        mPreferenceUseCase = new PreferenceUseCase(context);
    }

    /**
     * This will create a single-ton
     *
     * @param context Context
     */
    public static void Initialize(@NonNull Context context) {
        if (sDataManager == null) {
            synchronized (DataManager.class) {
                if (sDataManager == null) {
                    sDataManager = new DataManager(context);
                }
            }
        }
    }

    /**
     * Use this method to get the {@link DataManager} instance
     *
     * @return {@link DataManager} instance
     */
    public static DataManager getInstance() {
        // Null check
        if (sDataManager == null) {
            throw new RuntimeException("Use DataManager.Initialize(Context) to get the single " +
                    "instance of initialize DataManager and then use getInstance() to get the " +
                    "single instance of DataManager");
        }
        return sDataManager;
    }

    /**
     * Make singleton from serializable and deserialization operation
     *
     * @return The {@link DataManager} instance
     */
    protected DataManager readResolve() {
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
}
