package hr.fer.objobl.shopking.data.model.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiFood(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("company")
    val company: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("mass")
    val mass: String,

    @SerializedName("sale")
    val sale: Boolean

) : Serializable
