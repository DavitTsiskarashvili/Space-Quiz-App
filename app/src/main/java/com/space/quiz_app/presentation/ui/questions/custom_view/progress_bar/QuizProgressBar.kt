package com.space.quiz_app.presentation.ui.questions.custom_view.progress_bar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.space.quiz_app.R
import com.space.quiz_app.databinding.QuizProgressIndicatorCustomViewBinding

class QuizProgressBar(
    context: Context,
    attributeSet: AttributeSet
) : FrameLayout (context, attributeSet) {
    private val binding = QuizProgressIndicatorCustomViewBinding.inflate(LayoutInflater.from(context), this, true)

    private var maxScore = 0
    private var currentScore = 0
    private var totalCorrectAnswers = 0

    fun setMaxScore(quizMaxScore: Int){
        maxScore = quizMaxScore
        binding.progressBar.max = quizMaxScore
        setContent()
    }

    fun setCurrentScore(score: Int){
        totalCorrectAnswers = score
        setContent()
    }

    fun updateProgressBar(progressIndicator: Int){
        currentScore = progressIndicator
        setContent()
    }

    private fun setContent(){
        with(binding){
            val progress = "$currentScore/$maxScore"
            questionCounterTextView.text = progress
            scoreCounterTextView.text = context.getString(R.string.current_score, totalCorrectAnswers)
            progressBar.setProgress(currentScore, true)
        }
    }

    fun clearProgressBarValues(){
        maxScore = 0
        currentScore = 0
        totalCorrectAnswers = 0
        setContent()
    }

}