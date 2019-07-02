package com.apps.myapplication.data.source.local.model

import io.realm.RealmObject

// Author, Title,
//Picture of the book, category of the book: Fiction, Non-fiction
open class Book(
    var author: String?= null,
    var title: String?= null,
    var img: String?= null,
    var idcategory: Int?= null,
    var qty: Int?= null
) : RealmObject(){}