package com.space.quiz_app.presentation.quiz_login_screen.ui

import androidx.lifecycle.lifecycleScope
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizLoginFragmentBinding
import com.space.quiz_app.presentation.base.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_login_screen.view_model.QuizLoginViewModel
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class QuizLoginFragment : QuizBaseFragment<QuizLoginViewModel>() {

    private val binding by viewBinding(QuizLoginFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_login_fragment

    override val viewModelClass: KClass<QuizLoginViewModel>
        get() = QuizLoginViewModel::class

    override fun onBind() {
        logIn()
        observer()
    }

    private fun logIn() {
        binding.startButton.setOnClickListener {
            viewModel.isValidUsername(binding.usernameEditText.text.toString())
        }
    }

    private fun observer() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.navigate.collect {
                if (it) {
                    viewModel.navigate()
                }
            }
        }
    }

}