package com.aula.findcom

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.aula.constants.APP_NAME
import com.aula.db.Loja
import com.aula.findcom.db.LojaRepository
import kotlinx.android.synthetic.main.activity_lista_comercios.*

class ListaComercios : AppCompatActivity() {
    private var lojas: ArrayList<Loja>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_comercios)


        lista.setOnItemClickListener { _, _, position, id ->
            Log.i(APP_NAME, "position: $position id: " + lojas?.get(id.toInt())?.id)
            val intent = Intent(this@ListaComercios, DetalhesComercio::class.java)
            intent.putExtra("loja", lojas?.get(position))
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        lojas = LojaRepository(this).findAll()
        if(lojas != null){
            lista.adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1, lojas!!
            )
        }

    }
}