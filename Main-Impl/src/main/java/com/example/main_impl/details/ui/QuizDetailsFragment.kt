package com.example.main_impl.details.ui

import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.corecommon.common.extensions.observeNonNullValue
import com.example.corecommon.common.extensions.observeValue
import com.example.corecommon.common.extensions.setVisibility
import com.example.corecommon.common.extensions.viewBinding
import com.example.main_impl.databinding.QuizDetailsFragmentBinding
import com.example.main_impl.details.adapter.QuizDetailsAdapter
import com.example.main_impl.details.view_model.QuizDetailsViewModel
import com.example.main_impl.home.custom_view.log_out_dialog.LogOutDialog
import com.space.quiz_app.presentation.ui.details.ui.QuizDetailsFragmentDirections
import kotlin.reflect.KClass

class QuizDetailsFragment :
    com.example.corecommon.base.fragment.QuizBaseFragment<QuizDetailsViewModel>() {

    private val binding by viewBinding(QuizDetailsFragmentBinding::bind)

    override val layout: Int
        get() = com.example.main_impl.R.layout.quiz_details_fragment

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
                viewModel.logOutUser()
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