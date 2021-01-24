package hr.fer.objobl.shopking.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imageUrl: String) = Glide.with(this).load(imageUrl).into(this)
