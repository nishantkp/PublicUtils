package com.nishantkp.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

/**
 * This class deals with showing up toast messages
 */
@SuppressWarnings("unused")
public class ToastUtils {

    /**
     * Use this method to show short toast message
     *
     * @param c  context
     * @param ch message
     */
    public static void show(@NonNull Context c, CharSequence ch) {
        Toast.makeText(c, ch, Toast.LENGTH_SHORT).show();
    }

    /**
     * Use this method to show long toast message
     *
     * @param c  context
     * @param ch message
     */
    public static void showLong(@NonNull Context c, CharSequence ch) {
        Toast.makeText(c, ch, Toast.LENGTH_LONG).show();
    }

    /**
     * Use this method to show short toast message
     *
     * @param c     context
     * @param resId resource id
     */
    public static void show(@NonNull Context c, int resId) {
        Toast.makeText(c, c.getResources().getText(resId), Toast.LENGTH_SHORT).show();
    }

    /**
     * Use this method to show long toast message
     *
     * @param c     context
     * @param resId resource id
     */
    public static void showLong(@NonNull Context c, int resId) {
        Toast.makeText(c, c.getResources().getText(resId), Toast.LENGTH_LONG).show();
    }
}
