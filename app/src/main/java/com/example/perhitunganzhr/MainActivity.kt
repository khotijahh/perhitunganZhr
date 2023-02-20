package com.example.perhitunganzhr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var namaPengirim : EditText
    private lateinit var namaPenerima : EditText
    private lateinit var rbBri : RadioButton
    private lateinit var rbBca : RadioButton
    private lateinit var norekPengirim : EditText
    private lateinit var norekPenerima : EditText
    private lateinit var proses : Button
    private lateinit var DetailTransaksi :TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var hasil :TextView

    private lateinit var simpan :Button
    private lateinit var nominal : EditText

    private var rumus : Int = 0

    private var jumlah :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namaPengirim = findViewById(R.id.etNamaPengirim)
        namaPenerima = findViewById(R.id.etNamaPenerima)
        rbBri = findViewById(R.id.rbBri)
        rbBca = findViewById(R.id.rbBca)
        norekPengirim = findViewById(R.id.etNorekPengirim)
        norekPenerima = findViewById(R.id.etNorekPenerima)
        DetailTransaksi = findViewById(R.id.tvDetailTransaksi)
        nominal = findViewById(R.id.etNominal)

        proses = findViewById(R.id.btnProses)
        simpan = findViewById(R.id.btnSimpan)
        recyclerView = findViewById(R.id.ListData)
        hasil = findViewById(R.id.hasil)

        val data = mutableListOf<DataPerhitungan>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = editAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {
            val nmPengirim = namaPengirim.text.toString()
            val nmPenerima = namaPenerima.text.toString()
            val norekPengirim = norekPengirim.text.toString()
            val norekPenerima = norekPenerima.text.toString()
            val hasil = hasil.text.toString()

            val dataSiswa = DataPerhitungan(nmPengirim,nmPenerima,norekPengirim,norekPenerima,hasil)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }

        proses.setOnClickListener {

            val nominall = nominal.text.toString().toInt()

            if(rbBri.isChecked){
                rumus = (nominall - 2500)
                hasil.setText(rumus.toString())

            } else {
                rumus = (nominall - 5000)
                hasil.setText(rumus.toString())
            }

            jumlah = Integer.parseInt(nominal.text.toString())
            if (jumlah <= 100000){
                DetailTransaksi.setText("\n DetailTransaksi \n\n namaPengirim : "+namaPengirim.text.toString()+"\nnamaPenerima: "+namaPenerima.text.toString()+"\n+ norekPengirim: "+norekPengirim.text.toString()+"\n norekPenerima :"+norekPenerima.text.toString() );
            }
        }
    }
}