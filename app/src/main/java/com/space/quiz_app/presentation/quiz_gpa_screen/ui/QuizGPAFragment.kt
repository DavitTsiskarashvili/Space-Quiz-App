package com.space.quiz_app.presentation.quiz_gpa_screen.ui

import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizGpaFragmentBinding
import com.space.quiz_app.presentation.base.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_gpa_screen.view_model.QuizGPAViewModel
import kotlin.reflect.KClass

class QuizGPAFragment : QuizBaseFragment<QuizGPAViewModel>() {

    private val binding by viewBinding(QuizGpaFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_gpa_fragment

    override val viewModelClass: KClass<QuizGPAViewModel>
        get() = QuizGPAViewModel::class

    override fun onBind() {
        navigate()
    }

    private fun navigate() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding.backButton.setOnClickListener {
            findNavController().navigate(QuizGPAFragmentDirections.actionGpaFragmentToHomeFragment())
        }
    }

 }