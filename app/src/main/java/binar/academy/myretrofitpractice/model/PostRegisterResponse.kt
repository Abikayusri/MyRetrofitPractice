package binar.academy.myretrofitpractice.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class PostRegisterResponse(
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("role")
    val role: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null
) : Parcelable