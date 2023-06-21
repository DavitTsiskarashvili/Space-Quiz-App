package com.presentation.quiz_gpa_screen.ui

import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.base.fragment.QuizBaseFragment
import com.extensions.viewBinding
import com.presentation.quiz_gpa_screen.view_model.QuizGPAViewModel
import com.quiz.R
import com.quiz.databinding.QuizGpaFragmentBinding
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