package com.example.job1.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.job1.ActivityDetails
import com.example.job1.Model.Product
import com.example.job1.databinding.ItemProductBinding


/**
 * Adapter for displaying a list of [Product] items in a RecyclerView.
 *
 * @property list The list of products to be displayed.
 */
class ProductAdapter(
    private val list: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding)
    }



    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {


        val product = list[position]



        holder.binding.tvTitle.text = product.title


        holder.binding.tvPrice.text =
            "$${product.price}"


        holder.binding.tvCategory.text =
            product.category.name



        // IMAGE 1

        if(product.images.isNotEmpty()){

            Glide.with(holder.itemView.context)
                .load(product.images[0])
                .into(holder.binding.imgProduct)

        }



        // IMAGE 2

        if(product.images.size > 1){

            Glide.with(holder.itemView.context)
                .load(product.images[1])
                .into(holder.binding.imgProduct2)

        }
        else{

            holder.binding.imgProduct2.setImageDrawable(null)

        }



        // IMAGE 3

        if(product.images.size > 2){

            Glide.with(holder.itemView.context)
                .load(product.images[2])
                .into(holder.binding.imgProduct3)

        }
        else{

            holder.binding.imgProduct3.setImageDrawable(null)

        }




        holder.binding.root.setOnClickListener {


            val intent = Intent(
                holder.itemView.context,
                ActivityDetails::class.java
            )


            intent.putExtra(
                "title",
                product.title
            )


            intent.putExtra(
                "price",
                product.price
            )


            intent.putExtra(
                "category",
                product.category.name
            )


            intent.putExtra(
                "description",
                product.description
            )


            // safe image

            intent.putExtra(
                "image",
                product.images.firstOrNull()
            )



            holder.itemView.context.startActivity(intent)


        }


    }



    override fun getItemCount(): Int {

        return list.size

    }



    /**
     * ViewHolder for the [ProductAdapter], holding the layout binding for each product item.
     *
     * @property binding The binding object for the product item layout.
     */
    inner class ProductViewHolder(
        val binding: ItemProductBinding
    ):RecyclerView.ViewHolder(binding.root)

}