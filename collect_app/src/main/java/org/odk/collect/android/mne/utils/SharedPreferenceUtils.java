package org.odk.collect.android.mne.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceUtils {


    public static class PREF_VALUE_KEY {
        public static final String KEY_FCM = "fcm";
        public static final String KEY_TOKEN = "token";
    }




    /**
     * Called to saveCompletable supplied value in shared preferences against given key.
     *
     * @param context Context of caller activity
     * @param key     Key of value to saveCompletable against
     * @param value   Value to saveCompletable
     */
    public static void saveToPrefs(Context context, String key, String value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void saveBooloeanToPrefs(Context context, String key, Boolean value) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }


    public static void deleteAll(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.clear().commit();
    }


    public static void setChangeListener(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }


    /**
     * Called to retrieve required value siteName shared preferences, identified by given key.
     * Default value will be returned of no value found or error occurred.
     *
     * @param context      Context of caller activity
     * @param key          Key to find value against
     * @param defaultValue Value to return if no data found against given key
     * @return Return the value found against given key, default if not found or any error occurs
     */
    public static String getFromPrefs(Context context, String key, String defaultValue) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return sharedPrefs.getString(key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static Boolean getBooleanFromPrefs(Context context, String key, Boolean defaultValue) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return sharedPrefs.getBoolean(key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    /**
     * @param context Context of caller activity
     * @param key     Key to delete siteName SharedPreferences
     */
    public static void removeFromPrefs(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }

    public static String keySelectedRegionId(String projectId) {
        return String.format("project-id-%s", projectId);
    }

    public static String keySelectedRegionLabel(String label) {
        return String.format("project-label-%s", label);
    }

    public static String getSiteLisTitle(Context context, String projectId) {
        return getFromPrefs(context, keySelectedRegionLabel(projectId), "My Sites");
    }

}