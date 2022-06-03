package com.nikfen.customviewapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RectangleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultStyle: Int = 0
) : View(context, attrs, defaultStyle) {

    private var rectRadius: Float
    private var rectBorder: Float
    private var borderColor: Int

    private val paint = Paint()

    init {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.RectangleView,
            0, 0
        ).apply {
            try {
                rectRadius = getDimension(R.styleable.RectangleView_radius, 0f)
                rectBorder = getDimension(R.styleable.RectangleView_borderWidth, 0f)
                borderColor = getColor(R.styleable.RectangleView_color, Color.BLACK)
            } finally {
                recycle()
            }
        }
        paint.apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeWidth = rectBorder
            color = borderColor
        }

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        canvas?.drawRoundRect(
            0f + rectBorder / 2,
            0f + rectBorder / 2,
            width.toFloat() - rectBorder / 2,
            height.toFloat() - rectBorder / 2,
            rectRadius,
            rectRadius,
            paint
        )

    }
}