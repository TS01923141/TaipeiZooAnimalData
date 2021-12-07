package com.example.taipeizooanimaldata.model.adapter

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

private const val TAG = "AnimalDetailBindingAdap"
@BindingAdapter("imageFromUrl")
fun bindingImageFromUrl(view: ImageView, imageUrl: String?) {
    Log.d(TAG, "bindingImageFromUrl: imageUrl: $imageUrl")
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
//            .load("https://interactive-examples.mdn.mozilla.net/media/cc0-images/grapefruit-slice-332-332.jpg")
            //淡入淡出
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}