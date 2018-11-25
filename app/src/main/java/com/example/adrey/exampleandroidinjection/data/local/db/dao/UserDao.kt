package com.example.adrey.exampleandroidinjection.data.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.adrey.exampleandroidinjection.data.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User) : Long

    @Query("SELECT * FROM tUser WHERE idUser = :id LIMIT 1")
    fun getUser(id: Long): User
}