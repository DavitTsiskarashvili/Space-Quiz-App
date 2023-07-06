package com.example.main_impl.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.corecommon.common.extensions.loadImage
import com.example.corecommon.model.user.QuizUserSubjectUIModel
import com.example.main_impl.databinding.QuizSubjectItemBinding

class QuizDetailsAdapter :
    com.example.corecommon.base.adapter.BaseAdapter<QuizUserSubjectUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(
            QuizSubjectItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class DetailsViewHolder(val binding: QuizSubjectItemBinding) :
        BaseViewHolder<QuizUserSubjectUIModel>(binding) {
        override fun onBind(item: QuizUserSubjectUIModel) {
            with(item) {
                with(binding) {
                    titleTextView.text = quizTitle
                    descriptionTextView.text = quizDescription
                    subjectImageView.loadImage(quizIcon)
                    startButton.setCompoundDrawables(null, null, null, null)
                    startButton.text = score.toString()
                }
            }
        }
    }
}