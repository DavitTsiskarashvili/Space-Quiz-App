package com.presentation.ui

import com.base.fragment.QuizBaseFragment
import com.extensions.executeScope
import com.extensions.viewBinding
import com.login.R
import com.login.databinding.QuizLoginFragmentBinding
import com.presentation.view_model.QuizLoginViewModel
import kotlin.reflect.KClass

class QuizLoginFragment : QuizBaseFragment<QuizLoginViewModel>() {

    private val binding by viewBinding(QuizLoginFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_login_fragment

    override val viewModelClass: KClass<QuizLoginViewModel>
        get() = QuizLoginViewModel::class

    override fun onCreateFragment() {
        viewModel.checkUserLogState()
    }

    override fun onBind() {
        logIn()
        setErrorMessage()
    }

    private fun logIn() {
        with(binding){
            startButton.setOnClickListener {
                viewModel.checkUsernameValidity(usernameEditText.text.toString())
            }
        }
    }

    // errors in base fragment
    private fun setErrorMessage() {
        executeScope {
            viewModel.validationError.collect() {
                it?.let {
                    binding.errorTextView.text = getString(it.errorText)
                }
            }
        }
    }

}