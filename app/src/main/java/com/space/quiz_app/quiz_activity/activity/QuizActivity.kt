package com.space.quiz_app.quiz_activity.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.space.quiz_app.quiz_activity.view_model.QuizViewModel
import com.space.quiz_app.databinding.QuizActivityBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: QuizActivityBinding

    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = QuizActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}