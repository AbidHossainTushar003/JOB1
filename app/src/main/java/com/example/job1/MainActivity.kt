package com.example.job1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.job1.Adapter.ProductAdapter
import com.example.job1.api.RetrofitInstance
import com.example.job1.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recyclerView.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this)

        getProducts()

        binding.fabRetry.setOnClickListener {
            // startActivity(Intent(this, MainActivity::class.java))
            getProducts()
            Toast.makeText(this, "data reloaded", Toast.LENGTH_SHORT).show()
        }

    }


    private fun getProducts() {


        binding.fabRetry.isEnabled = false


        lifecycleScope.launch {

            try {


                val productList = withContext(Dispatchers.IO) {

                    RetrofitInstance.api.getProducts()

                }


                binding.recyclerView.adapter =
                    ProductAdapter(productList)



            }
            catch(e:Exception){


                Toast.makeText(
                    this@MainActivity,
                    "Error: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()


            }
            finally {


                binding.fabRetry.isEnabled = true


            }


        }


    }
    }
    /*  private fun getProducts() {
          RetrofitInstance.api.getProducts().enqueue(object : Callback<List<Product>> {
              override fun onResponse(
                  call: Call<List<Product>?>, response: Response<List<Product>?>
              ) {
                  if (response.isSuccessful) {
                      val productList = response.body() ?: emptyList()
                      binding.recyclerView.adapter = ProductAdapter(productList)
                  }
              }

              override fun onFailure(
                  call: Call<List<Product>?>, t: Throwable
              ) {
                  Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
              }


          })

      }*/
