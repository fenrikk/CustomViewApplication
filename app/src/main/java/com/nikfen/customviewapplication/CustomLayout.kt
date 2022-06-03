package com.nikfen.customviewapplication

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding

class CustomLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defstyle: Int = 0
) : LinearLayout(context, attrs, defstyle) {

    fun addItem(item: String) {
        val view = TextView(context)
        view.apply {
            text = item
            layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            textSize = 18f
            setPadding(4)
            setTextColor(Color.parseColor("#ffffff"))
            setBackgroundColor(Color.parseColor("#000000"))
        }
        addView(view)
    }
}