package com.space.quiz_app.presentation.quiz_questions_screen.ui

import android.os.Bundle
import androidx.core.view.isVisible
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.observeLiveData
import com.space.quiz_app.common.extensions.observeLiveDataNonNull
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizQuestionsFragmentBinding
import com.space.quiz_app.presentation.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_questions_screen.custom_view.cancel_quiz_dialog.CancelQuizDialog
import com.space.quiz_app.presentation.quiz_questions_screen.adapter.QuizAnswersAdapter
import com.space.quiz_app.presentation.quiz_questions_screen.view_model.QuizQuestionsViewModel
import com.space.quiz_app.presentation.utils.SubjectId
import kotlin.reflect.KClass

class QuizQuestionsFragment : QuizBaseFragment<QuizQuestionsViewModel>() {

    private val binding by viewBinding(QuizQuestionsFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_questions_fragment

    override val viewModelClass: KClass<QuizQuestionsViewModel>
        get() = QuizQuestionsViewModel::class

    private val answersAdapter by lazy {
        QuizAnswersAdapter()
    }

    override fun onCreateFragment() {
    }

    override fun onBind() {
        initRecycler()
        observe()
        cancelQuiz()

        val subjectId = arguments?.getInt(SubjectId.ARG_SUBJECT_ID, -1)?: -1
        viewModel.getAnswers(subjectId)

    }

    private fun initRecycler() {
        binding.answersRecyclerView.adapter = answersAdapter
    }

    private fun observe() {
        observeLiveData(viewModel.loadingState) {
            binding.progressBar.isVisible = it
        }
        observeLiveDataNonNull(viewModel.questionState){
            with(binding) {
                quizTitleTextView.text = it.questionTitle
            }
        }
        observeLiveDataNonNull(viewModel.answerState) { answers ->
            answers.let {
                answersAdapter.submitList(it)
            }
        }
    }

    private fun cancelQuiz() {
        binding.cancelButton.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        CancelQuizDialog(requireContext()).apply {
            setPositiveButtonClickListener {
                viewModel.navigateToHome()
            }
            setNegativeButtonClickListener { }
            showDialog()
        }
    }

}