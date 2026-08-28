package com.example.job1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.job1.databinding.ActivityDetailsBinding


class ActivityDetails : AppCompatActivity() {


    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivityDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)



        val title = intent.getStringExtra("title") ?: ""

        val price = intent.getDoubleExtra("price", 0.0)

        val category = intent.getStringExtra("category") ?: ""

        val description = intent.getStringExtra("description") ?: ""

        val image = intent.getStringExtra("image")



        binding.tvTitle.text = title

        binding.tvPrice.text = "$$price"

        binding.tvCategory.text = category

        binding.tvDescription.text = description



        if (!image.isNullOrEmpty()) {

            Glide.with(this)
                .load(image)
                .into(binding.imgProduct)

        }


    }

}