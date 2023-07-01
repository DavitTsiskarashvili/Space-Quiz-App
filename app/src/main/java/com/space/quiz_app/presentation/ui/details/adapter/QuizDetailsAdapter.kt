package com.space.quiz_app.presentation.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.space.quiz_app.common.extensions.loadImage
import com.space.quiz_app.databinding.QuizSubjectItemBinding
import com.space.quiz_app.presentation.feature.base.adapter.BaseAdapter
import com.space.quiz_app.presentation.feature.model.user.QuizUserSubjectUIModel

class QuizDetailsAdapter: BaseAdapter<QuizUserSubjectUIModel>() {

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
            with (item) {
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