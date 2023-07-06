package com.example.quiz_impl.presentation.questions.custom_view.congrats_dialog

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.corecommon.databinding.QuizCongratsDialogBinding

class QuizCongratsDialog(
    context: Context
) : FrameLayout(context) {
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

    fun setIcon(icon: Int) {
        binding.iconTextView.text = icon.toString()
    }

    fun setMessage(message: String) {
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