package com.space.quiz_app.presentation.quiz_home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.space.quiz_app.common.extensions.loadImage
import com.space.quiz_app.databinding.QuizSubjectItemBinding
import com.space.quiz_app.presentation.base.adapter.BaseAdapter
import com.space.quiz_app.presentation.model.questions.QuizQuestionsUIModel

class QuizSubjectsAdapter :
    BaseAdapter<QuizQuestionsUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {
        val viewHolder = SubjectsViewHolder(
            QuizSubjectItemBinding.inflate(
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

    class SubjectsViewHolder(private val binding: QuizSubjectItemBinding) :
        BaseViewHolder<QuizQuestionsUIModel>(binding) {
        override fun onBind(item: QuizQuestionsUIModel) {
            with(binding) {
                titleTextView.text = item.quizTitle
                descriptionTextView.text = item.quizDescription
                subjectImageView.loadImage(item.quizIcon)
            }
        }
    }
}