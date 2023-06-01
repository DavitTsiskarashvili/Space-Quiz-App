package com.space.quiz_app.di

import android.content.Context
import androidx.room.Room
import com.space.quiz_app.data.local.QuizUserDatabase
import org.koin.dsl.module

private fun provideUserDatabase(context: Context): QuizUserDatabase {
    return Room.databaseBuilder(context, QuizUserDatabase::class.java, "User_database")
        .fallbackToDestructiveMigration().build()
}

private fun provideDao(db: QuizUserDatabase) = db.userDao()

val dataBaseModule = module {
    single { provideUserDatabase(get()) }
    single { provideDao(get()) }
}