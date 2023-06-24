package com.space.quiz_app.data.module

import android.content.Context
import androidx.room.Room
import com.space.quiz_app.data.local.database.QuizDatabase
import org.koin.dsl.module

private fun provideUserDatabase(context: Context): QuizDatabase {
    return Room.databaseBuilder(context, QuizDatabase::class.java, "User_database")
        .fallbackToDestructiveMigration().build()
}

private fun provideDao(db: QuizDatabase) = db.userDao()

val dataBaseModule = module {
    single { provideUserDatabase(get()) }
    single { provideDao(get()) }
}