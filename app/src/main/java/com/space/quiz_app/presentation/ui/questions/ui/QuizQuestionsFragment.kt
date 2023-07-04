package com.space.quiz_app.presentation.ui.questions.ui

import androidx.activity.addCallback
import androidx.navigation.fragment.navArgs
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.observeLiveData
import com.space.quiz_app.common.extensions.observeLiveDataNonNull
import com.space.quiz_app.common.extensions.showCancelDialog
import com.space.quiz_app.common.extensions.showCongratsDialog
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizQuestionsFragmentBinding
import com.space.quiz_app.presentation.feature.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.ui.questions.adapter.QuizAnswersAdapter
import com.space.quiz_app.presentation.ui.questions.view_model.QuizQuestionsViewModel
import kotlin.reflect.KClass

class QuizQuestionsFragment : QuizBaseFragment<QuizQuestionsViewModel>() {

    private val binding by viewBinding(QuizQuestionsFragmentBinding::bind)
    private val args: QuizQuestionsFragmentArgs by navArgs()
    private var userScore = 0

    override val layout: Int
        get() = R.layout.quiz_questions_fragment

    override val viewModelClass: KClass<QuizQuestionsViewModel>
        get() = QuizQuestionsViewModel::class

    private val answersAdapter by lazy {
        QuizAnswersAdapter {
            viewModel.answerSelected()
        }
    }

    override fun onCreateFragment() {
        val subjectTitle = args.subjectUIModel.quizTitle
        viewModel.getAllQuestions(subjectTitle)
    }

    override fun onBind() {
        initRecycler()
        observe()
        cancelQuiz()
        nextQuestion()
        handleBackPress()
        updateButtonText()
        setListeners()
    }

    private fun initRecycler() {
        binding.answersRecyclerView.adapter = answersAdapter
    }

    private fun observe() {
        // question and answer states
        with(binding) {
            observeLiveDataNonNull(viewModel.questionState) {
                quizTitleTextView.text = it.subjectTitle
                questionBackground.setQuestion(it.questionTitle)
                progressBar.updateProgressBar(it.questionIndex)
            }
            observeLiveDataNonNull(viewModel.answerState) { answers ->
                answers.let {
                    answersAdapter.submitList(listOf(it))
                }
            }
            observeLiveData(viewModel.answerSelectedState) {
                nextButton.isEnabled = it
                nextButton.isClickable = it
            }
            observeLiveData(viewModel.userScoreState){
                userScore = it
                progressBar.setCurrentScore(userScore)
            }
            observeLiveData(viewModel.quizMaxScoreState){
                progressBar.setMaxScore(it)
            }
        }
    }

    private fun setListeners() {
        answersAdapter.correctAnswerListener = {
            if (it){
                viewModel.submitQuizScore()
            }
        }
    }

    private fun nextQuestion() {
        with(binding) {
            nextButton.setOnClickListener {
                viewModel.nextQuestion()
            }
        }
    }

    private fun updateButtonText() {
        observeLiveData(viewModel.finishQuizState) { isLastQuestion ->
            if (isLastQuestion) {
                binding.nextButton.text = getString(R.string.finish_button)
                showFinishDialog()
            } else {
                binding.nextButton.text = getString(R.string.next_button)
            }
        }
    }

    private fun cancelQuiz() {
        binding.cancelButton.setOnClickListener {
            showCancelDialog()
        }
    }

    private fun handleBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback {
            showCancelDialog()
        }
    }

    private fun showCancelDialog() {
        showCancelDialog {
            setPositiveButtonClickListener {
                viewModel.navigateToHome()
            }
            setNegativeButtonClickListener {
                dismissDialog()
            }
            showDialog()
        }
    }

    private fun showFinishDialog() {
        binding.nextButton.setOnClickListener {
            showCongratsDialog {
                setIcon(getString(R.string.congrats_icon))
                setMessage(getString(R.string.congratulations))
                setScore(String.format(getString(R.string.your_score_is), userScore))
                setPositiveButtonClickListener {
                    viewModel.navigateToHome()
                    binding.progressBar.clearProgressBarValues()
                }
                showDialog()
            }
        }
    }

}