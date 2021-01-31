package hr.fer.objobl.shopking.data.model.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiShop(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: String

) : Serializable
