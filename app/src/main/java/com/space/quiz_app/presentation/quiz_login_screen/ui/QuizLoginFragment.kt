package com.space.quiz_app.presentation.quiz_login_screen.ui

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
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

    override fun onBind(viewModel: QuizLoginViewModel) {
        logIn(viewModel)
    }

    private fun logIn(viewModel: QuizLoginViewModel) {
        binding.startButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            if (isValidUsername(username)) {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.checkLoginStatus(username)
                    navigate()
                }
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.invalid_username),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    private fun isValidUsername(username: String): Boolean {
        val pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
        return pattern.matches(username)
    }

    private fun navigate() {
        binding.startButton.setOnClickListener {
            findNavController().navigate(QuizLoginFragmentDirections.actionStartFragmentToHomeFragment())
        }
    }

}