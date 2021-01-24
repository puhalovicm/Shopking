package hr.fer.objobl.shopking.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import hr.fer.objobl.shopking.R

fun ImageView.load(imageUrl: String, @DrawableRes placeholder: Int = R.drawable.app_icon_blue) = Glide
    .with(this)
    .load(imageUrl)
    .placeholder(placeholder)
    .into(this)
