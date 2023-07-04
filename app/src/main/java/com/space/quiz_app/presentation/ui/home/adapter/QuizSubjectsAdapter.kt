package com.space.quiz_app.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.space.quiz_app.common.extensions.loadImage
import com.space.quiz_app.databinding.QuizSubjectItemBinding
import com.space.quiz_app.presentation.feature.base.adapter.BaseAdapter
import com.space.quiz_app.presentation.feature.model.subject.QuizSubjectUIModel

class QuizSubjectsAdapter :
    BaseAdapter<QuizSubjectUIModel>() {

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
        BaseViewHolder<QuizSubjectUIModel>(binding) {
        override fun onBind(item: QuizSubjectUIModel) {
            with(binding) {
                titleTextView.text = item.quizTitle
                descriptionTextView.text = item.quizDescription
                subjectImageView.loadImage(item.quizIcon)
            }
        }
    }
}