package com.space.quiz_app.presentation.ui.details.ui

import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.observeLiveData
import com.space.quiz_app.common.extensions.observeLiveDataNonNull
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
        observeLiveData(viewModel.loadingState) {
            binding.progressBar.isVisible = it
        }
        observeLiveDataNonNull(viewModel.userSubjectsState) { userSubjects ->
            userSubjects.let {
                if (it.isNotEmpty()) {
                    detailsAdapter.submitList(it.toList())
                    with(binding) {
                        noPointsTextView.visibility = View.GONE
                        userSubjectsRecyclerView.visibility = View.VISIBLE
                    }
                    Log.d("list", "$it")
                } else {
                    with(binding) {
                        userSubjectsRecyclerView.visibility = View.GONE
                        noPointsTextView.visibility = View.VISIBLE
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