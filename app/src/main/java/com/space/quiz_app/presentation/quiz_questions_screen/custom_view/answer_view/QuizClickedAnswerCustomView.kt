package com.space.quiz_app.presentation.quiz_questions_screen.custom_view.answer_view

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.space.quiz_app.R
import com.space.quiz_app.databinding.QuizAnswerItemBinding

class QuizClickedAnswerCustomView(
    context: Context,
) : FrameLayout(context) {

    private val binding = QuizAnswerItemBinding.inflate(LayoutInflater.from(context), this, true)
    private var correctAnswerPosition: Int? = null

    fun setAnswers(item: String) {
        binding.answerTextView.text = item
    }

    fun wrongAnswer(userAnswer: String, correctAnswer: String) {
        updateBackgroundColor(R.color.red_wrong)
        setScore(false)
    }

    fun correctAnswer(userAnswer: String, correctAnswer: String) {
        updateBackgroundColor(R.color.green_success)
        setScore(true)
    }

    fun setStandardBackgroundColor() {
        updateBackgroundColor(R.color.neutral_04_lighter_grey)
        changeTextColor(R.color.neutral_01_dark_grey)
        binding.scoreTextView.visibility = View.GONE
    }

    private fun changeTextColor(colorRes: Int) {
        binding.answerTextView.setTextColor(colorRes)
    }

    private fun updateBackgroundColor(colorRes: Int) {
        binding.root.backgroundTintList =
            ColorStateList.valueOf(colorRes)
    }

    private fun setScore(isVisible: Boolean) {
        binding.scoreTextView.visibility = if (isVisible) View.VISIBLE else GONE
    }
}