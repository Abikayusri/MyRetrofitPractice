package binar.academy.myretrofitpractice.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @author Abika Chairul Yusri created on 3/11/2022 at 11:54 PM.
 */
@Parcelize
data class RegisterRequest(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("role")
    val role: String? = "admin"
) : Parcelable