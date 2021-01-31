package hr.fer.objobl.shopking.utils

import android.content.res.Resources
import hr.fer.objobl.shopking.R

class ShopkingStringsImpl(
    private val resources: Resources
): ShopkingStrings {

    override fun notificationContent(): String = resources.getString(R.string.information_notifications_content)
}
