package com.tasneembohra.github.util

import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addSpaceItemDecor(@DimenRes dimensionResId: Int) =
    addItemDecoration(VerticalSpaceItemDecor(resources.getDimensionPixelOffset(dimensionResId)))

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}