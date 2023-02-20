package com.example.perhitunganzhr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class editAdapter(private val dataSet :MutableList<DataPerhitungan>):
        RecyclerView.Adapter<editAdapter.DataPerhitunganHolder>(){
    class DataPerhitunganHolder(view: View):RecyclerView.ViewHolder(view) {
        val NmPengirim = view.findViewById<TextView>(R.id.tvNmPengirimIsi)
        val NorekPengirim = view.findViewById<TextView>(R.id.tvNorekPengirimIsi)
        val NmPenerima = view.findViewById<TextView>(R.id.tvNmPenerimaIsi)
        val NorekPenerima = view.findViewById<TextView>(R.id.tvNorekPenerimaIsi)
        val Hasil = view.findViewById<TextView>(R.id.tvHasil)
        val Hapus = view.findViewById<ImageView>(R.id.icDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataPerhitunganHolder {
       val view = LayoutInflater.from(parent.context).inflate(
           R.layout.activity_edit_adapter,parent,false
       )
        return DataPerhitunganHolder(view)
    }

    override fun onBindViewHolder(holder: DataPerhitunganHolder, position: Int) {
        val data = dataSet[position]
        holder.NmPengirim.text = dataSet[position].NmPengirim
        holder.NorekPengirim.text = dataSet[position].NorekPengirim
        holder.NmPenerima.text = dataSet[position].NmPenerima
        holder.NorekPenerima.text = dataSet[position].NorekPenerima
        holder.Hasil.text = dataSet[position].Hasil
        holder.Hapus.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()

        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}