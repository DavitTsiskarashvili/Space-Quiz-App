package com.space.quiz_app.di

import android.content.Context
import androidx.room.Room
import com.space.quiz_app.data.local.UserDatabase
import org.koin.dsl.module

private fun provideUserDatabase(context: Context): UserDatabase {
    return Room.databaseBuilder(context, UserDatabase::class.java, "User_database")
        .fallbackToDestructiveMigration().build()
}

private fun provideDao(db: UserDatabase) = db.userDao()

val dataBaseModule = module {
    single { provideUserDatabase(get()) }
    single { provideDao(get()) }
}