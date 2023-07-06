package com.example.main_impl.login.ui

import androidx.annotation.StringRes
import com.example.corecommon.base.fragment.QuizBaseFragment
import com.example.corecommon.common.extensions.viewBinding
import com.example.main_impl.R
import com.example.main_impl.databinding.QuizLoginFragmentBinding
import com.example.main_impl.login.view_model.QuizLoginViewModel
import kotlin.reflect.KClass

class QuizLoginFragment : QuizBaseFragment<QuizLoginViewModel>() {

    private val binding by viewBinding(QuizLoginFragmentBinding::bind)

    override val layout: Int
        get() = R.layout.quiz_login_fragment

    override val viewModelClass: KClass<QuizLoginViewModel>
        get() = QuizLoginViewModel::class

    override fun onCreateFragment() {
        viewModel.checkUserLoggedInStatus()
    }

    override fun handleErrorState(@StringRes error: Int) {
        binding.errorTextView.text = getString(error)
    }

    override fun onBind() {
        logIn()
    }

    private fun logIn() {
        with(binding) {
            startButton.setOnClickListener {
                viewModel.login(usernameEditText.text.toString())
            }
        }
    }

}