package com.space.quiz_app.presentation.quiz_questions_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.quiz_app.databinding.QuizQuestionItemCustomViewBinding
import com.space.quiz_app.presentation.base.adapter.DiffUtilCallback
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel
import com.space.quiz_app.presentation.quiz_questions_screen.custom_view.answer_view.QuizClickedAnswerCustomView

class QuizAnswersAdapter :
    ListAdapter<QuizQuestionUIModel, QuizAnswersAdapter.AnswersViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswersViewHolder {
        return AnswersViewHolder(
            QuizQuestionItemCustomViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnswersViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.root.removeAllViews()
        currentItem.answers.forEach {
            holder.onBind(
                it,
                currentItem.correctAnswer,
                currentItem.answers.indexOf(currentItem.correctAnswer)
            )
        }
    }

    class AnswersViewHolder(
        val binding: QuizQuestionItemCustomViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            userAnswer: String,
            correctAnswer: String,
            position: Int,
        ) {
            with(binding) {
                val item = QuizClickedAnswerCustomView(root.context)
                root.addView(item)
                item.setAnswers(userAnswer)

                item.setOnClickListener {
                    root.children.forEach {
                        it.isClickable = false
                    }
                    if (userAnswer != correctAnswer) {
                        getItemView(position).wrongAnswer(userAnswer, correctAnswer)
                    } else {
                        getItemView(position).correctAnswer(userAnswer, correctAnswer)
                    }
                }
            }
        }

        private fun getItemView(position: Int) =
            binding.root.getChildAt(position) as QuizClickedAnswerCustomView
    }

}






