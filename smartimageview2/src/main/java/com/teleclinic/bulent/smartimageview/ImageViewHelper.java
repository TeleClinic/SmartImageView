package com.teleclinic.bulent.smartimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by bulent on 2/1/18.
 */

public class ImageViewHelper {

    public void putImage(final String url, final Context context, final ImageView imageView) {
        Glide.with(context).load(url).asBitmap().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(new BitmapImageViewTarget(imageView) {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                super.onResourceReady(bitmap, anim);
                Glide.with(context).load(url).centerCrop().into(imageView);
            }
        });
    }
}
