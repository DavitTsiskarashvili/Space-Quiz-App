package com.example.main_impl.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.corecommon.base.adapter.BaseAdapter
import com.example.corecommon.common.extensions.loadImage
import com.example.corecommon.model.subject.QuizSubjectUIModel
import com.example.main_impl.databinding.QuizSubjectItemBinding

class QuizSubjectsAdapter : BaseAdapter<QuizSubjectUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {
        val viewHolder = SubjectsViewHolder(
            QuizSubjectItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.binding.startButton.setOnClickListener {
            onClickCallback?.invoke(getItem(viewHolder.adapterPosition))
        }
        viewHolder.itemView.setOnClickListener {
            onClickCallback?.invoke(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    class SubjectsViewHolder(val binding: QuizSubjectItemBinding) :
        BaseViewHolder<QuizSubjectUIModel>(binding) {
        override fun onBind(item: QuizSubjectUIModel) {
            with(item) {
                with(binding) {
                    titleTextView.text = quizTitle
                    descriptionTextView.text = quizDescription
                    subjectImageView.loadImage(quizIcon)
                }
            }
        }
    }
}