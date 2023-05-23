package com.space.quiz_app.presentation.quiz_login_screen

import androidx.navigation.fragment.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizLoginFragmentBinding
import com.space.quiz_app.presentation.base.QuizBaseFragment
import kotlin.reflect.KClass

class QuizLoginFragment : QuizBaseFragment<QuizLoginViewModel>() {

    private val binding by viewBinding(QuizLoginFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_login_fragment

    override fun onBind() {
        navigate()
    }

    private fun navigate() {
        binding.startButton.setOnClickListener {
            findNavController().navigate(QuizLoginFragmentDirections.actionStartFragmentToHomeFragment())
        }
    }

}