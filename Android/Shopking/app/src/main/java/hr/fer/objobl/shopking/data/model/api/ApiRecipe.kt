package hr.fer.objobl.shopking.data.model.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiRecipe(

    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("difficulty")
    val difficulty: String,

    @SerializedName("ingredients")
    val ingredients: List<String>,

    @SerializedName("estimated_time")
    val estimatedTime: Int,

    @SerializedName("description")
    val description: String

) : Serializable
