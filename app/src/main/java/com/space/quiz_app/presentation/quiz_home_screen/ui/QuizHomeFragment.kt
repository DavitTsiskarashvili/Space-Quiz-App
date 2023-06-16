package com.space.quiz_app.presentation.quiz_home_screen.ui

import androidx.core.view.isVisible
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.collectFlow
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizHomeFragmentBinding
import com.space.quiz_app.presentation.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_home_screen.adapter.QuizSubjectsAdapter
import com.space.quiz_app.presentation.quiz_home_screen.log_out_dialog.LogOutDialog
import com.space.quiz_app.presentation.quiz_home_screen.view_model.QuizHomeViewModel
import kotlinx.coroutines.delay
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
        collectFlow(viewModel.usernameState) {
            binding.greetingTextView.text =
                String.format(getString(R.string.hello_user), it)
        }
        collectFlow(viewModel.loadingState) {
            binding.progressBar.isVisible = it
        }
        collectFlow(viewModel.subjectsState) { subjects ->
            subjects.let {
                subjectsAdapter.submitList(it)
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
        val dialog = LogOutDialog(requireContext())
        dialog.setPositiveButtonClickListener {
            viewModel.logOutUser { viewModel.navigateToHome() }
        }
        dialog.setNegativeButtonClickListener {

        }
        dialog.showDialog()
    }

    private fun setNavigation() {
        binding.gpaButton.gpaDetailsTextView.setOnClickListener {
            viewModel.navigateToGPA()
        }
        subjectsAdapter.onItemClickListener {
            viewModel.navigateToQuiz()
        }
    }

}