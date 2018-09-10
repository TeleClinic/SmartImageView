package com.teleclinic.bulent.smartimageview

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions


class SmartImageView : ImageView {

    private var mContext: Context? = null
    private var attrs: AttributeSet? = null
    private var styleAttr: Int? = null


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
        //readAttributes()
    }


    fun putImage(url: String) {

        val glideThumbnailOptions = RequestOptions()
                .centerCrop()
                .override(100,0)
                .placeholder(R.color.gray_minus_4)
                .error(R.color.gray_minus_4)
                .priority(Priority.NORMAL)

        mContext?.let {
            Glide.with(it)
                .load(url)
                .apply(glideThumbnailOptions)
                .into(this)
        }
    }
}
