package com.space.quiz_app.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View


class BackgroundCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val fillPaint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    private val path1 = Path()
    private val path2 = Path()
    private val rectF = RectF()

    init {
        fillPaint.color = 0x537FE7.toInt() // Set the fill color for the first path
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width.toFloat()
        val height = height.toFloat()
        val cornerRadius = height / 2f

// Drawing the first path
        path1.reset()
        path1.moveTo(0f, 0f)
        path1.lineTo(width, 0f)
        path1.lineTo(width, height - cornerRadius)
        rectF.set(width - 2 * cornerRadius, height - 2 * cornerRadius, width, height)
        path1.arcTo(rectF, 0f, 90f)
        path1.lineTo(0f, height)
        path1.close()

        canvas.drawPath(path1, fillPaint)

// Drawing the second path
        fillPaint.color = 0x537FE7.toInt() // Set the fill color for the second path
        fillPaint.alpha = 100 // Set the fill alpha for the second path

        path2.reset()
        path2.moveTo(0f, height / 2f)
        path2.cubicTo(0f, height / 4f, width / 3f, 0f, width, 0f)
        path2.lineTo(width, height - cornerRadius)
        rectF.set(width - 4 * cornerRadius, height - 1 * cornerRadius, width, height * 2)
        path2.arcTo(rectF, 0f, 90f)
        path2.lineTo(0f, height / 2f)
        path2.close()

        canvas.drawPath(path2, fillPaint)
    }
}



