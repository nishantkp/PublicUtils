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
