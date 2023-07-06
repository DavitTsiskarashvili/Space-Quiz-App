package com.example.quiz_impl.presentation.questions.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.corecommon.model.questions.QuizQuestionUIModel
import com.example.quiz_impl.databinding.QuizQuestionItemCustomViewBinding
import com.example.quiz_impl.presentation.questions.custom_view.answer_view.QuizClickedAnswerCustomView

class QuizAnswersAdapter(
    private val answerSelected: () -> Unit
) : ListAdapter<QuizQuestionUIModel, QuizAnswersAdapter.AnswersViewHolder>(com.example.corecommon.base.adapter.DiffUtilCallback()) {

    var correctAnswerListener: ((Boolean) -> Unit)? = null

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
                currentItem.answers.indexOf(currentItem.correctAnswer),
                answerSelected,
                correctAnswerListener
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
            answerSelected: () -> Unit,
            correctAnswerListener: ((Boolean) -> Unit)?
        ) {
            with(binding) {
                val item = QuizClickedAnswerCustomView(root.context)
                root.addView(item)
                item.setAnswers(userAnswer)

                item.setOnClickListener {
                    root.children.forEach {
                        it.isClickable = false
                    }

                    if (userAnswer == correctAnswer) {
                        item.correctAnswer()
                    } else {
                        item.wrongAnswer()
                        getItemView(position).actualAnswer()
                        Log.d("TAG", "${getItemView(position)}")
                    }
                    answerSelected()
                    correctAnswerListener?.invoke(userAnswer == correctAnswer)
                }
            }
        }

        private fun getItemView(position: Int) =
            binding.root.getChildAt(position) as QuizClickedAnswerCustomView
    }

}