package com.space.quiz_app.presentation.quiz_questions_screen.ui

import androidx.activity.addCallback
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.observeLiveDataNonNull
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizQuestionsFragmentBinding
import com.space.quiz_app.presentation.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_questions_screen.adapter.QuizAnswersAdapter
import com.space.quiz_app.presentation.quiz_questions_screen.custom_view.cancel_quiz_dialog.CancelQuizDialog
import com.space.quiz_app.presentation.quiz_questions_screen.view_model.QuizQuestionsViewModel
import com.space.quiz_app.presentation.utils.SubjectTitle
import kotlin.reflect.KClass

class QuizQuestionsFragment : QuizBaseFragment<QuizQuestionsViewModel>() {

    private val binding by viewBinding(QuizQuestionsFragmentBinding::bind)
    private var selectedAnswer: String? = null

    override val layout: Int
        get() = R.layout.quiz_questions_fragment

    override val viewModelClass: KClass<QuizQuestionsViewModel>
        get() = QuizQuestionsViewModel::class


    private val answersAdapter by lazy {
        QuizAnswersAdapter {answer ->
            selectedAnswer = answer
            binding.nextButton.isEnabled = selectedAnswer != null
        }
    }

    override fun onCreateFragment() {
        val subjectTitle = arguments?.getString(SubjectTitle.ARG_SUBJECT_TITLE)?: ""
        viewModel.getAllQuestions(subjectTitle)
    }

    override fun onBind() {
        initRecycler()
        observe()
        cancelQuiz()
        nextQuestion()
        handleBackPress()
    }

    private fun initRecycler() {
        binding.answersRecyclerView.adapter = answersAdapter
        binding.nextButton.isEnabled = selectedAnswer != null
    }

    private fun observe() {
        // question and answer states
        observeLiveDataNonNull(viewModel.questionState){
            with(binding) {
                quizTitleTextView.text = it.subjectTitle
                questionBackground.setQuestion(it.questionTitle)
                progressBar.updateProgressBar(it.questionIndex)
            }
        }
        observeLiveDataNonNull(viewModel.answerState) { answers ->
            answers.let {
                answersAdapter.submitList(listOf(it))
            }
        }
    }

    private fun nextQuestion() {
        with(binding){
            nextButton.setOnClickListener{
                viewModel.nextQuestion()
                selectedAnswer = null
                nextButton.isEnabled = false
            }
        }
    }

    private fun cancelQuiz() {
        binding.cancelButton.setOnClickListener {
            showDialog()
        }
    }

    private fun handleBackPress(){
        requireActivity().onBackPressedDispatcher.addCallback {
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