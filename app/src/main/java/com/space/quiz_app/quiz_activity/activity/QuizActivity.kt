package com.space.quiz_app.quiz_activity.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
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
    }
}