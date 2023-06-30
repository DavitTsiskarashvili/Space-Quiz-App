package com.space.quiz_app.data.local.module

import android.content.Context
import androidx.room.Room
import com.space.quiz_app.data.local.dao.QuizUserSubjectsDao
import com.space.quiz_app.data.local.database.QuizDatabase
import org.koin.dsl.module

private fun provideUserDatabase(context: Context): QuizDatabase {
    return Room.databaseBuilder(context, QuizDatabase::class.java, "User_database")
        .fallbackToDestructiveMigration().build()
}

private fun provideUserDao(db: QuizDatabase) = db.userDao()
private fun provideSubjectDao(db: QuizDatabase) = db.subjectsDao()

private fun provideQuestionsDao(db: QuizDatabase) = db.questionsDao()

private fun provideUserSubjectsDao(db: QuizDatabase) = db.userSubjectsDao()
val dataBaseModule = module {
    single { provideUserDatabase(get()) }
    single { provideUserDao(get()) }
    single { provideSubjectDao(get()) }
    single { provideQuestionsDao(get()) }
    single { provideUserSubjectsDao(get()) }
}