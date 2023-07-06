package com.example.quiz_impl.presentation.questions.custom_view.answer_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.corecommon.R
import com.example.quiz_impl.databinding.QuizAnswerItemBinding
class QuizClickedAnswerCustomView(
    context: Context,
) : FrameLayout(context) {

    private val binding = QuizAnswerItemBinding.inflate(LayoutInflater.from(context), this, true)

    fun setAnswers(item: String) {
        binding.answerTextView.text = item
    }

    fun correctAnswer() {
        updateBackgroundColor(R.color.green_success)
        changeTextColor(R.color.white)
        setScore(true)
    }

    fun wrongAnswer() {
        updateBackgroundColor(R.color.red_wrong)
        changeTextColor(R.color.white)
        setScore(false)
    }

    fun actualAnswer() {
        updateBackgroundColor(R.color.green_success)
        changeTextColor(R.color.white)
        setScore(false)
    }

    private fun updateBackgroundColor(colorRes: Int) {
        binding.root.backgroundTintList = ContextCompat.getColorStateList(context, colorRes)
    }

    private fun changeTextColor(colorRes: Int) {
        binding.answerTextView.setTextColor(ContextCompat.getColor(context, colorRes))
    }

     private fun setScore(isVisible: Boolean) {
        binding.scoreTextView.visibility = if (isVisible) View.VISIBLE else GONE
    }

}