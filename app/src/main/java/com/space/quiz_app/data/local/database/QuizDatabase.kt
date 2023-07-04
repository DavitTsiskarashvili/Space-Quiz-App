package com.space.quiz_app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.space.quiz_app.data.local.dao.QuizQuestionsDao
import com.space.quiz_app.data.local.dao.QuizSubjectsDao
import com.space.quiz_app.data.local.dao.QuizUserDao
import com.space.quiz_app.data.local.entity.QuizQuestionEntity
import com.space.quiz_app.data.local.entity.QuizSubjectEntity
import com.space.quiz_app.data.local.entity.QuizUserEntity

@Database(entities = [QuizUserEntity::class, QuizSubjectEntity::class, QuizQuestionEntity::class], version = 4)
abstract class QuizDatabase: RoomDatabase() {
    abstract fun userDao(): QuizUserDao
    abstract fun subjectsDao(): QuizSubjectsDao
    abstract fun questionsDao(): QuizQuestionsDao
}