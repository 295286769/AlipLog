package com.aliyun.sls.kotlin.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.aliyun.sls.R

/**
 * Created by huangweishui on 2018/4/16.
 */
class FirstKotlinView : View {
    private var name: String = ""
    lateinit private var paith: Paint

    constructor(context: Context?) : this(context, null) {

    }

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0) {

    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        paith = Paint()
        paith.isAntiAlias=true
        paith.color= R.color.colorAccent
        paith.textSize=resources.getDimension(R.dimen.button_text_size)
    }

    init {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawText(name,0f,100f,paith)

    }

    fun setName(name: String) {
        this.name = name;
    }

}