package com.example.adrey.exampleandroidinjection.data

import com.example.adrey.exampleandroidinjection.data.local.db.DbHelper
import com.example.adrey.exampleandroidinjection.data.local.prefs.PrefersHelper

interface DataManager : DbHelper, PrefersHelper {

    // create interface method for app data manager
}