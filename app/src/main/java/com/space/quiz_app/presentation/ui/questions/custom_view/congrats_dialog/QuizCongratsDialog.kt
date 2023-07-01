package com.space.quiz_app.presentation.ui.questions.custom_view.congrats_dialog

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.space.quiz_app.R
import com.space.quiz_app.databinding.QuizCongratsDialogBinding
import com.space.quiz_app.presentation.ui.questions.custom_view.cancel_quiz_dialog.Dialog

class QuizCongratsDialog (
    context: Context
) : FrameLayout(context), Dialog {
    private val binding: QuizCongratsDialogBinding =
        QuizCongratsDialogBinding.inflate(LayoutInflater.from(context), this, true)

    private lateinit var alertDialog: AlertDialog

    init {
        setupDialog()
    }

    private fun setupDialog() {
        alertDialog = AlertDialog.Builder(context).setView(this).create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun setIcon(icon: String){
        binding.iconTextView.text = icon
    }

    fun setMessage(message: String){
        binding.congratsTextView.text = message
    }
    fun setScore(score: String) {
        binding.scoreTextView.text = score
    }

    fun showDialog() {
        alertDialog.show()
    }

    fun setPositiveButtonClickListener(onClickListener: () -> Unit) {
        binding.closeTextView.setOnClickListener {
            onClickListener.invoke()
            alertDialog.dismiss()
        }
    }

}