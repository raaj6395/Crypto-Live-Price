package com.example.cryptoliveprice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoliveprice.databinding.ItemBinding

class RvAdapter(val context :Context, var data : ArrayList<Modal>):RecyclerView.Adapter<RvAdapter.ViewHolder> (){

    fun changedata(filterdata: ArrayList<Modal>)
    {
        data=filterdata
    notifyDataSetChanged()
    }






    inner class  ViewHolder (val binding: ItemBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.ViewHolder {
        val view=ItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) {
        setAnimation(holder.itemView)
       holder.binding.name.text=data.get(position).name
        holder.binding.symbol.text=data.get(position).symbol
        holder.binding.price.text=data.get(position).price
    }

    override fun getItemCount(): Int {
      return data.size
    }
    fun setAnimation(view: View){
      val anim=AlphaAnimation(0.01f,1.0f)
        anim.duration=1000
        view.startAnimation(anim)
    }
}