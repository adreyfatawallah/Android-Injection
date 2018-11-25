package com.example.adrey.exampleandroidinjection.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tUser")
class User {

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }

    @PrimaryKey(autoGenerate = true)
    var idUser = 0

    @ColumnInfo(name = "username")
    var username = ""

    @ColumnInfo(name = "password")
    var password = ""

    override fun toString(): String {
        return "User(idUser=$idUser, username='$username', password='$password')"
    }
}