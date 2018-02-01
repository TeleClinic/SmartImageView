package com.teleclinic.bulent.smartimageview;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

/**
 * Created by bulent on 2/1/18.
 */

public class ImageViewHelper {

    private void putImage(String url, Context context, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        GlideDrawableImageViewTarget glideTarget = (GlideDrawableImageViewTarget) target;
                        ImageView iv = glideTarget.getView();
                        int width = iv.getMeasuredWidth();
                        int targetHeight = width * resource.getIntrinsicHeight() / resource.getIntrinsicWidth();
                        if (iv.getLayoutParams().height != targetHeight) {
                            iv.getLayoutParams().height = targetHeight;
                            iv.requestLayout();
                        } return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }
}
