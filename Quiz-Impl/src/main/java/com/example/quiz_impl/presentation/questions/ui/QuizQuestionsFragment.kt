package com.example.quiz_impl.presentation.questions.ui

import androidx.activity.addCallback
import com.example.corecommon.base.fragment.QuizBaseFragment
import com.example.corecommon.common.extensions.observeNonNullValue
import com.example.corecommon.common.extensions.observeValue
import com.example.corecommon.common.extensions.viewBinding
import com.example.quiz_impl.R
import com.example.quiz_impl.databinding.QuizQuestionsFragmentBinding
import com.example.quiz_impl.extensions.showCancelDialog
import com.example.quiz_impl.extensions.showCongratsDialog
import com.example.quiz_impl.presentation.questions.adapter.QuizAnswersAdapter
import com.example.quiz_impl.presentation.questions.view_model.QuizQuestionsViewModel
import kotlin.reflect.KClass

class QuizQuestionsFragment : QuizBaseFragment<QuizQuestionsViewModel>() {

    private val binding by viewBinding(QuizQuestionsFragmentBinding::bind)
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
//        val subjectTitle = args.subjectUIModel.quizTitle
//        viewModel.getAllQuestionsBySubject(subjectTitle)
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
            observeNonNullValue(viewModel.quizLiveData) {
                quizTitleTextView.text = it.subjectTitle
                progressBar.updateProgressBar(it.questionIndex + 1)
                questionBackground.setQuestion(it.questionTitle)
            }
            observeNonNullValue(viewModel.quizLiveData) { answers ->
                answers.let {
                    answersAdapter.submitList(listOf(it))
                }
            }
            observeValue(viewModel.answerSelectedLiveData) {
                nextButton.isEnabled = it
                nextButton.isClickable = it
            }
            observeValue(viewModel.userScoreLiveData) {
                userScore = it
                progressBar.setCurrentScore(userScore)
            }
            observeValue(viewModel.quizMaxQuestionLiveData) {
                progressBar.setMaxQuestion(it)
            }
        }
    }

    private fun setListeners() {
        answersAdapter.correctAnswerListener = {
            if (it) {
                viewModel.submitQuizScore()
            }
        }
    }

    private fun nextQuestion() {
        with(binding) {
            nextButton.setOnClickListener {
                viewModel.setQuestionAndAnswers()
            }
        }
    }

    private fun updateButtonText() {
        observeValue(viewModel.finishQuizLiveData) { isLastQuestion ->
            if (isLastQuestion) {
                binding.nextButton.text = getString(R.string.finish_button)
                binding.nextButton.setOnClickListener {
                    finishQuiz()
                }
            } else {
                binding.nextButton.text = getString(R.string.next_button)
            }
        }
    }

    private fun finishQuiz() {
        observeValue(viewModel.usernameLiveData) {
            val username = it
//            val subjectTitle = args.subjectUIModel
            val userScore = viewModel.userScoreLiveData.value ?: 0
//            viewModel.saveUserScore(username, subjectTitle, userScore)
        }
        if (userScore == 0) {
            showFinishDialog(noScore = true)
        } else {
            showFinishDialog(noScore = false)
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
//                viewModel.navigateToHome()
            }
            setNegativeButtonClickListener {
                dismissDialog()
            }
            showDialog()
        }
    }

    private fun showFinishDialog(noScore: Boolean) {
        showCongratsDialog {
            if (noScore) {
                setIcon(R.string.low_score_emoji)
                setScore(String.format(getString(R.string.your_score_is), userScore))
            } else {
                setIcon(R.string.congrats_emoji)
                setMessage(getString(R.string.congratulations))
            }
            setScore(String.format(getString(R.string.your_score_is), userScore))
            setPositiveButtonClickListener {
//                viewModel.navigateToHome()
                binding.progressBar.clearProgressBarValues()
            }
            showDialog()
        }
    }

}