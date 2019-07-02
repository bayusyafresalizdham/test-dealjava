package com.apps.myapplication.data.source.local.model

import io.realm.RealmObject

open class Category(
    var name: String?= null
) : RealmObject(){}