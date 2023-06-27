package com.space.quiz_app.presentation.quiz_questions_screen.custom_view.answer_view

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.space.quiz_app.R
import com.space.quiz_app.databinding.QuizQuestionItemBinding
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel

class QuizClickedAnswerCustomView(
    context: Context,
    attributeSet: AttributeSet
    ): FrameLayout(context, attributeSet) {
        private val binding = QuizQuestionItemBinding.inflate(LayoutInflater.from(context), this, true)
    private var correctAnswerPosition: Int? = null


    fun setCorrectAnswerPosition(position: Int) {
        correctAnswerPosition = position
    }

    fun setAnswers(item: QuizQuestionUIModel.Answer) {
        binding.answerTextView.text = item.answerOption
    }

    fun setAnswerStatus(answerView: Int, correctAnswerView: Int, positionView: Int){
        changeTextColor(R.color.neutral_white)
        when(positionView) {
            answerView -> {
                if (answerView == correctAnswerView) {
                    updateBackgroundColor(R.color.green_success)
                    setScore(true)
                } else {
                    updateBackgroundColor(R.color.red_wrong)
                    setScore(false)
                }
            }
            correctAnswerView -> {
                updateBackgroundColor(R.color.green_success)
                setScore(false)
            }
        }
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