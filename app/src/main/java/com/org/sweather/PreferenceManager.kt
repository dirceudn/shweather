package com.org.sweather

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.org.sweather.core.ModelPreferenceContract
import com.org.sweather.core.search.data.model.CityData

/**
 * Singleton class for managing preferences for POJO or model class's object.
 * @author Malwinder Singh
 * medium.com/@dev.malwinder
 */
class ModelPreferencesManager(private val application: SweatherApplication) :
    ModelPreferenceContract {

    var preferences: SharedPreferences

    private val PREFERENCES_FILE_NAME = "PREFERENCES_FILE_NAME"

    init {
        preferences = application.getSharedPreferences(
            PREFERENCES_FILE_NAME, Context.MODE_PRIVATE
        )
    }

    /**
     * Call this first before retrieving or saving object.
     *
     * @param application Instance of application class
     */


    /**
     * Saves object into the Preferences.
     *
     * @param `object` Object of model class (of type [T]) to save
     * @param key Key with which Shared preferences to
     **/
    override fun <T> put(`object`: T, key: String) {
        //Convert object to JSON String.
        val jsonString = GsonBuilder().create().toJson(`object`)
        //Save that String in SharedPreferences
        preferences.edit().putString(key, jsonString).apply()
    }

    /**
     * Used to retrieve object from the Preferences.
     *
     * @param key Shared Preference key with which object was saved.
     **/
    override fun get(key: String): CityData? {
        //We read JSON String which was saved.
        val value = preferences.getString(key, null)
        //JSON String was found which means object can be read.
        //We convert this JSON String to model object. Parameter "c" (of
        //type Class < T >" is used to cast.
        return GsonBuilder().create().fromJson(value, CityData::class.java)
    }

    override fun enableMetric(enable: Boolean, key: String) {
        preferences.edit().putBoolean(key, enable).apply()
    }

    override fun isMetricEnable(): Boolean =
        preferences.getBoolean(ModelPreferenceContract.ENABLE_METRIC, true)
}