package com.aula.findcom.db

import android.content.Context
import android.util.Log
import com.aula.constants.APP_NAME
import com.aula.constants.CONTATOS_DB_NAME
import org.jetbrains.anko.db.*
import com.aula.db.Loja

class LojaRepository(val context: Context)  {
    fun findAll() : ArrayList<Loja> = context.database.use {
        val lojas = ArrayList<Loja>()

        select(CONTATOS_DB_NAME, "id",
            "email",
            "endereco",
            "nome",
            "telefone",
            "site",
            "foto")
            .parseList(object: MapRowParser<List<Loja>> {
                override fun parseRow(columns: Map<String, Any?>): List<Loja> {
                    lojas.add(Loja(
                        id = columns.getValue("id").toString()?.toLong(),
                        foto = columns.getValue("foto")?.toString(),
                        nome = columns.getValue("nome")?.toString(),
                        endereco = columns.getValue("endereco")?.toString(),
                        telefone = columns.getValue("telefone")?.toString()?.toLong(),
                        email = columns.getValue("email")?.toString(),
                        site = columns.getValue("site")?.toString()))
                    return lojas
                }
            })
        lojas
    }
}

