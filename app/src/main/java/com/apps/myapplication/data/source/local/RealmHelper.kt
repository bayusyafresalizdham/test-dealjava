package com.apps.myapplication.data.source.local

import android.content.Context
import io.realm.Realm

class RealmHelper {
    companion object{
        fun getrealm(mcontext: Context): Realm {
            Realm.init(mcontext)
            return Realm.getDefaultInstance()
        }
    }
}