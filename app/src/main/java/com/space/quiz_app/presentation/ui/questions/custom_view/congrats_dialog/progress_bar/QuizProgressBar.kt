package com.space.quiz_app.presentation.ui.questions.custom_view.congrats_dialog.progress_bar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.space.quiz_app.R
import com.space.quiz_app.databinding.QuizProgressIndicatorCustomViewBinding

class QuizProgressBar(
    context: Context,
    attributeSet: AttributeSet
) : FrameLayout(context, attributeSet) {
    private val binding =
        QuizProgressIndicatorCustomViewBinding.inflate(LayoutInflater.from(context), this, true)

    private var maxQuestion = 0
    private var currentQuestion = 0
    private var totalCorrectAnswers = 0

    fun setMaxQuestion(quizMaxQuestion: Int) {
        maxQuestion = quizMaxQuestion
        binding.progressBar.max = quizMaxQuestion
        setContent()
    }

    fun setCurrentScore(score: Int) {
        totalCorrectAnswers = score
        setContent()
    }

    fun updateProgressBar(progressIndicator: Int) {
        currentQuestion = progressIndicator
        setContent()
    }

    private fun setContent() {
        with(binding) {
            val progress = "$currentQuestion/$maxQuestion"
            questionCounterTextView.text = progress
            scoreCounterTextView.text =
                context.getString(R.string.current_score, totalCorrectAnswers)
            progressBar.setProgress(currentQuestion, true)
        }
    }

    fun clearProgressBarValues() {
        maxQuestion = 0
        currentQuestion = 0
        totalCorrectAnswers = 0
        setContent()
    }

}