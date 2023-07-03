package com.space.quiz_app.presentation.quiz_home_screen.custom_view.log_out_dialog

import com.space.quiz_app.databinding.QuizCloseDialogBinding
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

class LogOutDialog @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {
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

    fun setPositiveButtonClickListener(onClickListener: () -> Unit) {
        binding.yesButton.setOnClickListener {
            onClickListener.invoke()
            alertDialog.dismiss()
        }
    }

    fun setNegativeButtonClickListener(onClickListener: () -> Unit) {
        binding.noButton.setOnClickListener {
            onClickListener.invoke()
            alertDialog.dismiss()
        }
    }

}