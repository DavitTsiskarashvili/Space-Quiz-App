package com.space.quiz_app.presentation.quiz_home_screen.ui

import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.collectFlow
import com.space.quiz_app.common.extensions.executeScope
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizHomeFragmentBinding
import com.space.quiz_app.presentation.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_home_screen.adapter.QuizSubjectsAdapter
import com.space.quiz_app.presentation.quiz_home_screen.view_model.QuizHomeViewModel
import kotlinx.coroutines.launch
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

    override fun onBind() {
        initRecycler()
        navigate()
        observe()
    }

    private fun initRecycler() {
        viewModel.getSubjects()
        binding.subjectRecyclerView.adapter = subjectsAdapter
        getSubjects()
    }

    private fun getSubjects() {
        collectFlow(viewModel.loadingState) {
            binding.progressBar.isVisible = it
        }
        collectFlow(viewModel.subjectsState) { subjects ->
            subjects.let {
                subjectsAdapter.submitList(it)
            }
        }
    }

    private fun navigate() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding.logOutButton.setOnClickListener {
            findNavController().navigate(QuizHomeFragmentDirections.actionHomeFragmentToQuestionsFragment())
        }
    }

    private fun observe() {
        viewModel.getUsername()
        executeScope {
            viewModel.usernameState.collect {
                binding.greetingTextView.text =
                    String.format(getString(R.string.hello_user), it)
            }
        }
    }

}