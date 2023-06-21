package com.presentation.quiz_questions_screen.ui

import androidx.navigation.fragment.findNavController
import com.base.fragment.QuizBaseFragment
import com.extensions.viewBinding
import com.presentation.quiz_questions_screen.view_model.QuizQuestionsViewModel
import com.quiz.R
import com.quiz.databinding.QuizQuestionsFragmentBinding
import kotlin.reflect.KClass

class QuizQuestionsFragment : QuizBaseFragment<QuizQuestionsViewModel>() {

    private val binding by viewBinding(QuizQuestionsFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_questions_fragment

    override val viewModelClass: KClass<QuizQuestionsViewModel>
        get() = QuizQuestionsViewModel::class

    override fun onCreateFragment() {
    }

    override fun onBind() {
        navigate()
    }

    private fun navigate() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(QuizQuestionsFragmentDirections.actionGlobalHomeFragment())
        }
    }

}