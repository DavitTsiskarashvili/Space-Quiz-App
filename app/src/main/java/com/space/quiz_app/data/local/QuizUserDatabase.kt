package com.space.quiz_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuizUserEntity::class], version = 1)
abstract class QuizUserDatabase: RoomDatabase() {
    abstract fun userDao(): QuizUserDao
}