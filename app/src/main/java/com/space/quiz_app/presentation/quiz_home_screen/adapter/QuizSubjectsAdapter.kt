package com.space.quiz_app.presentation.quiz_home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.quiz_app.common.extensions.loadImage
import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import com.space.quiz_app.databinding.QuizSubjectItemBinding
import com.space.quiz_app.presentation.base.adapter.BaseAdapter
import com.space.quiz_app.presentation.base.adapter.DiffUtilCallback
import com.space.quiz_app.presentation.model.questions.QuizQuestionsUIModel

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
        BaseAdapter.BaseViewHolder<QuizQuestionsUIModel>(binding) {
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