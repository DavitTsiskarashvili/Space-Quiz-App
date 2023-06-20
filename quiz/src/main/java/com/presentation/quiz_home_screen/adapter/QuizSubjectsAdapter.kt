package com.presentation.quiz_home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.extensions.loadImage
import com.presentation.base.adapter.BaseAdapter
import com.presentation.model.questions.QuizQuestionsUIModel
import com.quiz.databinding.QuizSubjectItemBinding

class QuizSubjectsAdapter :
    BaseAdapter<QuizQuestionsUIModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder {
        return SubjectsViewHolder(
            QuizSubjectItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class SubjectsViewHolder(private val binding: QuizSubjectItemBinding) :
        BaseViewHolder<QuizQuestionsUIModel>(binding) {
        override fun onBind(
            model: QuizQuestionsUIModel,
            itemCallback: ((QuizQuestionsUIModel) -> Unit)?
        ) {
            with(binding) {
                titleTextView.text = model.quizTitle
                descriptionTextView.text = model.quizDescription
                subjectImageView.loadImage(model.quizIcon)
                root.setOnClickListener {
                    itemCallback?.invoke(model)
                }
            }
        }
    }
}