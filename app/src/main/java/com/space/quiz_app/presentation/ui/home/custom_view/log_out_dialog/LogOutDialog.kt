package com.space.quiz_app.presentation.ui.home.custom_view.log_out_dialog

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.space.quiz_app.databinding.QuizCloseDialogBinding

class LogOutDialog (
    context: Context,
) : FrameLayout(context) {
    private val binding: QuizCloseDialogBinding =
        QuizCloseDialogBinding.inflate(LayoutInflater.from(context), this, true)

    private lateinit var alertDialog: AlertDialog

    init {
        setupDialog()
    }

    private fun setupDialog() {
        alertDialog = AlertDialog.Builder(context).setView(this).create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun showDialog() {
        alertDialog.show()
    }

    fun dismissDialog(){
        alertDialog.dismiss()
    }

    fun setPositiveButtonClickListener(onClickListener: () -> Unit) {
        binding.yesButton.setOnClickListener {
            onClickListener.invoke()
            alertDialog.dismiss()
        }
    }

    fun setNegativeButtonClickListener(onClickListener: () -> Unit) {
        binding.noButton.setOnClickListener {
            onClickListener.invoke()
        }
    }

}