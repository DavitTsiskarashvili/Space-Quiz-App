package com.space.quiz_app.presentation.ui.login.ui

import com.space.quiz_app.R
import com.space.quiz_app.common.extensions.executeScope
import com.space.quiz_app.common.extensions.viewBinding
import com.space.quiz_app.databinding.QuizLoginFragmentBinding
import com.space.quiz_app.presentation.feature.base.fragment.QuizBaseFragment
import com.space.quiz_app.presentation.ui.login.view_model.QuizLoginViewModel
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