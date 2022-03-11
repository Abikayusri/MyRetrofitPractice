package binar.academy.myretrofitpractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import binar.academy.myretrofitpractice.databinding.ActivityMainBinding
import binar.academy.myretrofitpractice.model.GetAllCarResponseItem
import binar.academy.myretrofitpractice.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchAllData()
        setupView()
    }

    private fun setupView() {
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
        }
    }

    private fun fetchAllData() {
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<GetAllCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    val body = response.body()
                    val code = response.code()
                    if (code == 200) {
                        showList(body)
                        binding.pbLoading.visibility = View.GONE
                    } else {
                        binding.pbLoading.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                    binding.pbLoading.visibility = View.GONE
                }
            })
    }

    private fun showList(data: List<GetAllCarResponseItem>?) {
        val adapter = MainAdapter(object : MainAdapter.OnClickListener {
            override fun onClickItem(data: GetAllCarResponseItem) {

            }
        })

        adapter.submitData(data)
        binding.rvList.adapter = adapter
    }
}