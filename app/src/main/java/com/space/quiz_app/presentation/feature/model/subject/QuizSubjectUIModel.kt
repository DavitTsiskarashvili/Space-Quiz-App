package com.space.quiz_app.presentation.feature.model.subject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuizSubjectUIModel(
    val id: Int,
    val quizTitle: String,
    val quizDescription: String,
    val quizIcon: String,
    val questionsCount: Int,
): Parcelable