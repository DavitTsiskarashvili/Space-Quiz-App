package com.space.quiz_app.presentation.ui.details.ui

import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.observeNonNullValue
import com.space.quiz_app.common.extensions.observeValue
import com.space.quiz_app.common.extensions.setVisibility
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizDetailsFragmentBinding
import com.space.quiz_app.presentation.feature.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.ui.details.adapter.QuizDetailsAdapter
import com.space.quiz_app.presentation.ui.details.view_model.QuizDetailsViewModel
import com.space.quiz_app.presentation.ui.home.custom_view.log_out_dialog.LogOutDialog
import kotlin.reflect.KClass

class QuizDetailsFragment : QuizBaseFragment<QuizDetailsViewModel>() {

    private val binding by viewBinding(QuizDetailsFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_details_fragment

    override val viewModelClass: KClass<QuizDetailsViewModel>
        get() = QuizDetailsViewModel::class

    private val detailsAdapter by lazy {
        QuizDetailsAdapter()
    }

    override fun onCreateFragment() {
        viewModel.getUserSubjects()
    }

    override fun onBind() {
        initRecycler()
        observe()
        navigate()
        logOut()
    }

    private fun initRecycler() {
        binding.userSubjectsRecyclerView.adapter = detailsAdapter
    }

    private fun observe() {
        observeValue(viewModel.loadingLiveData) {
            binding.progressBar.isVisible = it
        }
        observeNonNullValue(viewModel.userSubjectsLiveData) { userSubjects ->
            userSubjects.let {
                with(binding) {
                    if (it.isNotEmpty()) {
                        detailsAdapter.submitList(it)
                        noPointsTextView.setVisibility(false)
                        userSubjectsRecyclerView.setVisibility(true)
                    } else {
                        userSubjectsRecyclerView.setVisibility(false)
                        noPointsTextView.setVisibility(true)
                    }
                }
            }
        }
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

    private fun navigate() {
        binding.backButton.setOnClickListener {
            viewModel.navigateToHome()
        }
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(QuizDetailsFragmentDirections.actionGlobalHomeFragment())
        }
    }

}