package com.example.appaula.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Anotação necessária para ser interpretada como tabela/entidade
@Entity(tableName = "clientes")
data class Cliente (
    // Podem ser usadas anotações para modificar os atributos
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nome: String,
    val endereco: String,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val estado: String
)

// Data class -> Dao (interface) -> Database (abstract class) -> Repository
