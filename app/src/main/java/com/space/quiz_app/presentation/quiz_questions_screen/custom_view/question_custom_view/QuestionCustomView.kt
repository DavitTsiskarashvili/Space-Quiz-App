package com.space.quiz_app.presentation.quiz_questions_screen.custom_view.question_custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.space.quiz_app.databinding.QuizQuestionCardViewBinding

class QuestionCustomView(
    context: Context,
    attributeSet: AttributeSet
) : FrameLayout(context, attributeSet) {
    private val binding =
        QuizQuestionCardViewBinding.inflate(LayoutInflater.from(context), this, true)

    fun setQuestion(question: String) {
        binding.question.text = question
    }
}