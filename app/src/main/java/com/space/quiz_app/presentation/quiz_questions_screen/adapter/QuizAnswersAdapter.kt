package com.space.quiz_app.presentation.quiz_questions_screen.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.quiz_app.databinding.QuizQuestionItemCustomViewBinding
import com.space.quiz_app.presentation.base.adapter.DiffUtilCallback
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel

class QuizAnswersAdapter(private val answerClickListener: (Int) -> Unit) :
    ListAdapter<QuizQuestionUIModel.Answer, QuizAnswersAdapter.AnswersViewHolder>(DiffUtilCallback()) {

    //    var onClickCallback: ((answerIndex: Int) -> Unit)
    var correctAnswer: Int? = null
    private var userAnswer: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswersViewHolder {
        val viewHolder = AnswersViewHolder(
            QuizQuestionItemCustomViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                answerClickListener.invoke(position)
                userAnswer = position
                notifyDataSetChanged()
//            onAnswerClick(it)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: AnswersViewHolder, position: Int) {
        holder.onBind(
            getItem(position),
            correctAnswer!!,
            userAnswer,
        )
    }

    class AnswersViewHolder(
        private val binding: QuizQuestionItemCustomViewBinding,
//        var onClickCallback: ((answerIndex: Int) -> Unit)
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(answer: QuizQuestionUIModel.Answer, correctAnswer: Int, userAnswer: Int?
        ) {
            with(binding) {
                root.setAnswers(answer)

                if (userAnswer != null && (userAnswer == adapterPosition || correctAnswer == adapterPosition)) {
                    root.setAnswerStatus(userAnswer, correctAnswer, adapterPosition)
                } else {
                    root.setStandardBackgroundColor()
                }
//                binding.root.setOnClickListener {
//                    if (userAnswer == null) {
//                        onClickCallback(adapterPosition)
//                    }
            }
        }
    }
}

//    @SuppressLint("NotifyDataSetChanged")
//    fun onAnswerClick(userAnswer: Int) {
//        onClickCallback(userAnswer)
//        this.userAnswer = userAnswer
//
//        notifyItemChanged(userAnswer)
//
//        if (userAnswer != correctAnswer) {
//            notifyItemChanged(correctAnswer!!)
//        }
//    }



