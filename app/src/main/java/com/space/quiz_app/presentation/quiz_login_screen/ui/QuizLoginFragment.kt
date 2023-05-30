package com.space.quiz_app.presentation.quiz_login_screen.ui

import androidx.lifecycle.lifecycleScope
import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizLoginFragmentBinding
import com.space.quiz_app.presentation.base.QuizBaseFragment
import com.space.quiz_app.presentation.quiz_login_screen.view_model.QuizLoginViewModel
import kotlinx.coroutines.flow.collect
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
        setErrorMessage()
    }

    private fun logIn() {
        binding.startButton.setOnClickListener {
            viewModel.isValidUsername(binding.usernameEditText.text.toString())
        }
    }

    private fun setErrorMessage() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.validationError.collect() {
                it?.let {
                    binding.errorTextView.text = getString(it.errorText)
                }
            }
        }
    }

}