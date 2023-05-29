package com.space.quiz_app.presentation.quiz_questions_screen.ui

import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizQuestionsFragmentBinding
import com.space.quiz_app.presentation.base.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_questions_screen.view_model.QuizQuestionsViewModelQuiz
import kotlin.reflect.KClass

class QuizQuestionsFragment : QuizBaseFragment<QuizQuestionsViewModelQuiz>() {

    private val binding by viewBinding(QuizQuestionsFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_questions_fragment

    override val viewModelClass: KClass<QuizQuestionsViewModelQuiz>
        get() = QuizQuestionsViewModelQuiz::class

    override fun onBind() {
        navigate()
    }

    private fun navigate() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(QuizQuestionsFragmentDirections.actionQuestionsFragmentToHomeFragment())
        }
    }

}