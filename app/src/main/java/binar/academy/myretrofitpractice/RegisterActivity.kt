package binar.academy.myretrofitpractice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import binar.academy.myretrofitpractice.databinding.ActivityRegisterBinding
import binar.academy.myretrofitpractice.model.PostRegisterResponse
import binar.academy.myretrofitpractice.model.RegisterRequest
import binar.academy.myretrofitpractice.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.apply {
            btnRegist.setOnClickListener {
                if (!etEmail.text.isNullOrEmpty() && !etPassword.text.isNullOrEmpty()) {
                    registerAction(etEmail.text.toString(), etPassword.text.toString())
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Data tidak boleh kosong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun registerAction(email: String, password: String) {
        val request = RegisterRequest(
            email = email,
            password = password,
            role = "admin"
        )

        ApiClient.instance.postRegister(request)
            .enqueue(object : Callback<PostRegisterResponse> {
                override fun onResponse(
                    call: Call<PostRegisterResponse>,
                    response: Response<PostRegisterResponse>
                ) {
                    val code = response.code()
                    if (code == 200) {
                        binding.pbLoading.visibility = View.GONE
                        Toast.makeText(
                            this@RegisterActivity,
                            "Registrasi Berhasil",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        binding.pbLoading.visibility = View.GONE
                        Toast.makeText(
                            this@RegisterActivity,
                            "Email sudah tersedia",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<PostRegisterResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                    binding.pbLoading.visibility = View.GONE
                }
            })
    }
}