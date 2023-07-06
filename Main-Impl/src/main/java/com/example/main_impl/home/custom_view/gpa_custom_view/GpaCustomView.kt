package com.example.main_impl.home.custom_view.gpa_custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.main_impl.databinding.QuizGpaCardViewBinding

class GpaCustomView(
    context: Context,
    attributeSet: AttributeSet
) : FrameLayout(context, attributeSet) {
    private val binding =
        QuizGpaCardViewBinding.inflate(LayoutInflater.from(context), this, true)

    fun setScore(gpa: Float) {
        binding.gpaScoreTextView.text = gpa.toString()
    }

    fun setOnClickListener(block: () -> Unit) {
        binding.gpaDetailsTextView.setOnClickListener {
            block.invoke()
        }
    }
}