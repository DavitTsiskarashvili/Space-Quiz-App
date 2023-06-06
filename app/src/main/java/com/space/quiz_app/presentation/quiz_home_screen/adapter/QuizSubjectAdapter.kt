package com.space.quiz_app.presentation.quiz_home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.quiz_app.common.extensions.loadImage
import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import com.space.quiz_app.databinding.QuizSubjectItemBinding
import com.space.quiz_app.presentation.base.adapter.DiffUtilCallback
import com.space.quiz_app.presentation.model.questions.QuizQuestionsUIModel

class QuizSubjectsAdapter :
    ListAdapter<QuizQuestionsUIModel, QuizSubjectsAdapter.SubjectsViewHolder>(DiffUtilCallback<QuizQuestionsUIModel>()) {

    private var itemCallback: ((QuizQuestionsUIModel) -> Unit)? = null
    fun setOnClickListener(block: (QuizQuestionsUIModel) -> Unit) {
        itemCallback = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectsViewHolder =
        SubjectsViewHolder(
            QuizSubjectItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SubjectsViewHolder, position: Int) {
        holder.onBind(getItem(position), itemCallback)
    }

    class SubjectsViewHolder(private val binding: QuizSubjectItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: QuizQuestionsUIModel, itemCallback: ((QuizQuestionsUIModel) -> Unit)?) {
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