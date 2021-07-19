package com.org.sweather.navigation.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle

class OnSettingsRoute : OnSettingsContract {

    private var data: String? = null

    override fun setup(dataToPass: String) {
        data = dataToPass
    }

    override fun present(fromContext: Context) {
        val intent = Intent("com.org.sweather.settings.SettingsActivity")
        val bundle = Bundle()
        bundle.putString("data", data)
        intent.putExtras(bundle)
        fromContext.startActivity(intent)
    }
}