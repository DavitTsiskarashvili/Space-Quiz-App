package com.space.quiz_app.presentation.quiz_gpa_screen.ui

import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizGpaFragmentBinding
import com.space.quiz_app.presentation.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_gpa_screen.view_model.QuizGPAViewModel
import kotlin.reflect.KClass

class QuizGPAFragment : QuizBaseFragment<QuizGPAViewModel>() {

    private val binding by viewBinding(QuizGpaFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_gpa_fragment

    override val viewModelClass: KClass<QuizGPAViewModel>
        get() = QuizGPAViewModel::class

    override fun onCreateFragment() {

    }

    override fun onBind() {
        navigate()
    }

    private fun navigate() {
        // TODO navigation will be written in ViewModel
        binding.backButton.setOnClickListener {
            findNavController().navigate(QuizGPAFragmentDirections.actionGlobalHomeFragment())
        }
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(QuizGPAFragmentDirections.actionGlobalHomeFragment())
        }
    }

}