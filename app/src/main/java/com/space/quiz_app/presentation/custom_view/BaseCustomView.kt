package com.space.quiz_app.presentation.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.util.AttributeSet
import android.view.View

abstract class BaseCustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    protected val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
    }
    protected val path = Path()
    protected val width get() = getWidth().toFloat()
    protected val height get() = getHeight().toFloat()

    abstract fun drawBackground (canvas: Canvas)
    abstract fun onBind(canvas: Canvas)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        onBind(canvas)
    }
}