package com.example.corecommon.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "question")
@TypeConverters(ListStringConverter::class)
data class QuizQuestionEntity(
    @PrimaryKey(autoGenerate = false)
    val questionTitle: String = "",
    val answers: List<String>,
    val correctAnswer: String = "",
    val subjectId: Int,
    val subjectTitle: String,
    val questionIndex: Int = -1,
    val isAnswered: Boolean,
    val isLastQuestion: Boolean
)
