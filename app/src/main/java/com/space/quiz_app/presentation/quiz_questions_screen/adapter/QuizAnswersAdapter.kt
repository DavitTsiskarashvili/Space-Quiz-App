package com.space.quiz_app.presentation.quiz_questions_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.space.quiz_app.databinding.QuizQuestionItemBinding
import com.space.quiz_app.presentation.base.adapter.BaseAdapter
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel

class QuizAnswersAdapter :
    BaseAdapter<QuizQuestionUIModel.Answer>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val viewHolder = QuestionsViewHolder(
            QuizQuestionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            onClickCallback?.invoke(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    class QuestionsViewHolder(private val binding: QuizQuestionItemBinding) :
        BaseViewHolder<QuizQuestionUIModel.Answer>(binding) {
        override fun onBind(item: QuizQuestionUIModel.Answer) {
            with(binding) {
                answerTextView.text = item.answerOption
            }
        }
    }
}