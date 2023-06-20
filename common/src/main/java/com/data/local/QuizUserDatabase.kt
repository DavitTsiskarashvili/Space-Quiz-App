package com.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuizUserEntity::class], version = 3)
abstract class QuizUserDatabase: RoomDatabase() {
    abstract fun userDao(): QuizUserDao
}