package com.space.quiz_app.presentation.quiz_home_screen

import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizHomeFragmentBinding
import com.space.quiz_app.presentation.base.QuizBaseFragment
import kotlin.reflect.KClass

class QuizHomeFragment : QuizBaseFragment<QuizHomeViewModel>() {

    private val binding by viewBinding(QuizHomeFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_home_fragment

    override val viewModelClass: KClass<QuizHomeViewModel>
        get() = QuizHomeViewModel::class

    override fun onBind() {
        navigate()
    }

    private fun navigate() {
        // This is just to navigate onto the next screen and test it on the actual device
        binding.logOutButton.setOnClickListener {
            findNavController().navigate(QuizHomeFragmentDirections.actionHomeFragmentToQuestionsFragment())
        }
        binding.gpaButton.gpaDetailsTextView.setOnClickListener {
            findNavController().navigate(QuizHomeFragmentDirections.actionHomeFragmentToTakenQuizFragment())
        }
    }

}