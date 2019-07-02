package com.apps.myapplication.data.source.local.model

import io.realm.RealmObject

open class Loan(
    var date_borrow: String?= null,
    var date_return: String?= null,
    var idbook: Int?= null
) : RealmObject(){}