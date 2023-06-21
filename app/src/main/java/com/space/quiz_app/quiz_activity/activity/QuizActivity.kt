package com.space.quiz_app.quiz_activity.activity

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.space.quiz_app.R
import com.space.quiz_app.databinding.QuizActivityBinding
import com.space.quiz_app.quiz_activity.view_model.QuizViewModel

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: QuizActivityBinding

    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val deepLinkUri = Uri.Builder()
            .scheme("http")
            .authority("quiz_app.com")
            .path("/login")
            .build()

        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(deepLinkUri)
    }
}