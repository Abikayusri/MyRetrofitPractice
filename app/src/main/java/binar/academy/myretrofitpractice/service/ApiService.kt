package binar.academy.myretrofitpractice.service

import binar.academy.myretrofitpractice.model.GetAllCarResponseItem
import binar.academy.myretrofitpractice.model.PostRegisterResponse
import binar.academy.myretrofitpractice.model.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @author Abika Chairul Yusri created on 3/11/2022 at 10:17 PM.
 */
interface ApiService {

    // GET digunakan untuk memanggil semua data yang terdapat pada server
    @GET("admin/car")
    fun getAllCar(): Call<List<GetAllCarResponseItem>>

    // POST digunakan untuk menambahkan data ke server
    @POST("admin/auth/register")
    fun postRegister(@Body request: RegisterRequest): Call<PostRegisterResponse>
}