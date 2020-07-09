package com.tasneembohra.github.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:visibility")
fun setVisibility(view: View, value: Boolean?) {
    if (value == true) view.visibility = View.VISIBLE
    else view.visibility = View.GONE
}

@BindingAdapter("bind:avatar")
fun setAvatar(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}