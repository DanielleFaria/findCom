package com.aula.findcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aula.db.Loja
import kotlinx.android.synthetic.main.activity_detalhes_comercio.*

class DetalhesComercio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_comercio)
    }

    override fun onResume() {
        super.onResume()
        val loja = intent?.getSerializableExtra("loja")
        if(loja != null){
            loja as Loja
            NomeLoja.text = (loja?.nome)
            endereco.text = (loja?.endereco)
        }
    }
}