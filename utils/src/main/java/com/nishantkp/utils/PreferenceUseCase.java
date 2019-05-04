package com.nishantkp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Preference use case, use this to store, retrieve or check the preferences
 */
@SuppressWarnings("unused")
final class PreferenceUseCase {
    private SharedPreferences mSharedPreferences;

    protected PreferenceUseCase(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Use this method to store string to the preferences
     *
     * @param key   key
     * @param value value
     */
    protected void putString(@NonNull String key, @NonNull String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * Use this method to store boolean to the preferences
     *
     * @param key   key
     * @param value value
     */
    protected void putBoolean(@NonNull String key, @NonNull Boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    /**
     * Use this method to store integer to the preferences
     *
     * @param key   key
     * @param value value
     */
    protected void putInt(@NonNull String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    /**
     * Use this method to get the string from the preference based on key
     *
     * @param key key
     * @return if the preference is present it will return it's value and if there is no
     * preference with specified key, it will return null
     */
    @Nullable
    protected String getString(@NonNull String key) {
        return contains(key) ? mSharedPreferences.getString(key, "") : null;
    }

    /**
     * Use this method to get the boolean from the preference based on key
     *
     * @param key key
     * @return if the preference is present it will return it's value and if there is no
     * preference with specified key, it will return false
     */
    protected Boolean getBoolean(@NonNull String key) {
        return contains(key) && mSharedPreferences.getBoolean(key, false);
    }

    /**
     * Use this method to get the string from the preference based on key
     *
     * @param key key
     * @return if the preference is present it will return it's value and if there is no
     * preference with specified key, it will return {@link Integer#MAX_VALUE}
     */
    protected int getInt(@NonNull String key) {
        return contains(key) ? mSharedPreferences.getInt(key, Integer.MAX_VALUE) :
                Integer.MAX_VALUE;
    }

    /**
     * Use this method to remove the particular preference with key.
     * This method will first check of the preference exists or not, and if it exists it will be
     * removed
     *
     * @param key key
     */
    protected void remove(@NonNull String key) {
        if (contains(key)) {
            mSharedPreferences.edit().remove(key).apply();
        }
    }

    /**
     * Use this method to check if the preference is exists or not
     *
     * @param key Preference key
     * @return true if the preference is exists and false is not
     */
    protected Boolean contains(@NonNull String key) {
        return mSharedPreferences.contains(key);
    }
}