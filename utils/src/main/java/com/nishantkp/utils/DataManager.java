package com.nishantkp.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class DataManager implements Serializable {

    private static volatile DataManager sDataManager;

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
}
