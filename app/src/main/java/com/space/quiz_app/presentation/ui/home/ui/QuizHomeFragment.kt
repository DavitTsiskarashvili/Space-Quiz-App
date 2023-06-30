package com.space.quiz_app.presentation.ui.home.ui

import android.widget.Toast
import androidx.core.view.isVisible
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.observeLiveData
import com.space.quiz_app.common.extensions.observeLiveDataNonNull
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizHomeFragmentBinding
import com.space.quiz_app.presentation.feature.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.ui.home.adapter.QuizSubjectsAdapter
import com.space.quiz_app.presentation.ui.questions.custom_view.cancel_quiz_dialog.CancelQuizDialog
import com.space.quiz_app.presentation.ui.home.view_model.QuizHomeViewModel
import kotlin.reflect.KClass

class QuizHomeFragment : QuizBaseFragment<QuizHomeViewModel>() {

    private val binding by viewBinding(QuizHomeFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_home_fragment

    override val viewModelClass: KClass<QuizHomeViewModel>
        get() = QuizHomeViewModel::class

    private val subjectsAdapter by lazy {
        QuizSubjectsAdapter()
    }

    override fun onCreateFragment() {
        viewModel.getUsername()
    }

    override fun onBind() {
        observe()
        initRecycler()
        logOut()
        setNavigation()
    }

    private fun observe() {
        observeLiveData(viewModel.usernameState) {
            binding.greetingTextView.text =
                getString(R.string.hello_user, it)
        }
        observeLiveData(viewModel.loadingState) {
            binding.progressBar.isVisible = it
        }
        observeLiveDataNonNull(viewModel.subjectsState) { subjects ->
            subjects.let {
                subjectsAdapter.submitList(it)
            }
            observeLiveDataNonNull(viewModel.errorState) {
                Toast.makeText(requireContext(), getString(R.string.username_invalid_characters), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initRecycler() {
        viewModel.getSubjects()
        binding.subjectRecyclerView.adapter = subjectsAdapter
    }

    private fun logOut() {
        binding.logOutButton.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        CancelQuizDialog(requireContext()).apply {
            setPositiveButtonClickListener {
                viewModel.logOutUser { viewModel.navigateToHome() }
            }
            setNegativeButtonClickListener {
                dismissDialog()
            }
            showDialog()
        }
    }

    private fun setNavigation() {
        binding.gpaButton.setOnClickListener {
            viewModel.navigateToGPA()
        }
        subjectsAdapter.onItemClickListener { subjectTitle ->
            viewModel.onSubjectItemClick(subjectTitle.quizTitle)
            viewModel.navigateToQuiz(subjectTitle.quizTitle)
        }
    }

}