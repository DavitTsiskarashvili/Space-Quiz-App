package com.example.main_impl.home.ui

import androidx.activity.addCallback
import androidx.core.view.isVisible
import com.example.corecommon.R
import com.example.corecommon.common.extensions.observeNonNullValue
import com.example.corecommon.common.extensions.observeValue
import com.example.corecommon.common.extensions.viewBinding
import com.example.main_impl.databinding.QuizHomeFragmentBinding
import com.example.main_impl.home.adapter.QuizSubjectsAdapter
import com.example.main_impl.home.custom_view.log_out_dialog.LogOutDialog
import com.example.main_impl.home.view_model.QuizHomeViewModel
import kotlin.reflect.KClass

class QuizHomeFragment :
    com.example.corecommon.base.fragment.QuizBaseFragment<QuizHomeViewModel>() {

    private val binding by viewBinding(QuizHomeFragmentBinding::bind)

    override val layout: Int
        get() = com.example.main_impl.R.layout.quiz_home_fragment

    override val viewModelClass: KClass<QuizHomeViewModel>
        get() = QuizHomeViewModel::class

    private val subjectsAdapter by lazy {
        QuizSubjectsAdapter()
    }

    override fun onCreateFragment() {
        viewModel.getUser()
    }

    override fun onBind() {
        observe()
        initRecycler()
        logOut()
        setNavigation()
    }

    private fun observe() {
        observeValue(viewModel.userLiveData) {
            it?.let {
                binding.greetingTextView.text =
                    getString(R.string.hello_user, it.username)
                binding.gpaButton.setScore(it.gpa)
            }
        }
        observeValue(viewModel.loadingLiveData) {
            binding.progressBar.isVisible = it
        }
        observeNonNullValue(viewModel.subjectsLiveData) { subjects ->
            subjects.let {
                subjectsAdapter.submitList(it)
            }
        }
    }

    private fun initRecycler() {
        viewModel.retrieveSubjects()
        binding.subjectsRecyclerView.adapter = subjectsAdapter
    }

    private fun logOut() {
        binding.logOutButton.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        LogOutDialog(requireContext()).apply {
            setPositiveButtonClickListener {
                viewModel.logOutUser { viewModel.navigateToLogin() }
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
        subjectsAdapter.onItemClickListener { subject ->
            viewModel.onSubjectItemClick(subject)
            viewModel.navigateToQuiz(subject)
        }
        requireActivity().onBackPressedDispatcher.addCallback {
            requireActivity().finish()
        }
    }

}