package com.teleclinic.bulent.smartimageview

import android.content.Context
import android.util.AttributeSet
import android.util.Log.d
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_smart_image_view.view.*


/**
 * Created by bulent on 12/28/17.
 */

class SmartImageViewLayout : FrameLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null
    private var styleAttr: Int? = null
    private var view = View.inflate(context, R.layout.activity_smart_image_view, null)
    private var radius = 0f

    constructor(context: Context) : super(context) {
        init(context, null, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, null)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int?) {
        this.mContext = context
        this.attrs = attrs
        this.styleAttr = defStyleAttr
        addView(view)

        readAttributes()
    }

    fun readAttributes() {
        val arr = mContext?.theme?.obtainStyledAttributes(attrs, R.styleable.SmartImageViewLayout, 0, 0)
        arr?.let {
            if (it.getInt(R.styleable.SmartImageViewLayout_shape, -1) != -1) {
                setShape(Shape.values()[it.getInt(R.styleable.SmartImageViewLayout_shape, -1)])
            }
        }
    }

    fun putImages(vararg urls: String) {
        val count = urls.size
        when (count) {
            1 -> {
                smartImageView1.putImage(urls[0])
                textView.visibility = View.GONE
                linearLayout1.visibility = View.GONE
                frameLayout1.visibility = View.GONE
            }
            2 -> {
                smartImageView1.putImage(urls[0])
                smartImageView2.putImage(urls[1])
                textView.visibility = View.GONE
                linearLayout1.visibility = View.VISIBLE
                frameLayout1.visibility = View.GONE
            }
            3 -> {
                smartImageView1.putImage(urls[0])
                smartImageView2.putImage(urls[1])
                smartImageView3.putImage(urls[2])
                textView.visibility = View.GONE
                linearLayout1.visibility = View.VISIBLE
                frameLayout1.visibility = View.VISIBLE
            }
            else -> {
                smartImageView1.putImage(urls[0])
                smartImageView2.putImage(urls[1])
                smartImageView3.putImage(urls[2])
                textView.text = "+${count - 3}"
                textView.visibility = View.VISIBLE
                linearLayout1.visibility = View.VISIBLE
                frameLayout1.visibility = View.VISIBLE
            }
        }
    }

    private fun setShape(shape: Shape) {
        view.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view.viewTreeObserver.removeOnGlobalLayoutListener(this)
                cardView.layoutParams.height = view.height
                cardView.layoutParams.width = view.width
                val min = minOf(view.height, view.width)
                radius = min / 2f
                when (shape) {
                    Shape.SQUARE -> cardView.radius = 0f
                    Shape.CIRCLE -> {
                        cardView.radius = radius
                        textView.setPadding( 0,0,min / 20,min / 20)
                    }
                }
                //
                textView.textSize = maxOf(12f,radius/7f)
            }
        })
        d("shape::: " , "$shape")

    }
}

enum class Shape {
    SQUARE,
    CIRCLE
}