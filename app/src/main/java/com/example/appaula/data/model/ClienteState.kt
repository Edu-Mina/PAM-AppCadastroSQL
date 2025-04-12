package com.example.appaula.data.model

import kotlin.String

// Representa a entidade Cliente na UI
// Pode guardar informações adicionais, mas o ideal para isso é criar outra classe, uma apenas com os campos
data class ClienteState(
    var id: Int = 0,
    var nome: String = "",
    var endereco: String = "",
    var bairro: String = "",
    var cep: String = "",
    var cidade: String = "",
    var estado: String = ""
)

// Função padrão para conversão de ClienteState para Cliente
fun ClienteState.toCliente(): Cliente = Cliente(
    id = id,
    nome = nome,
    endereco = endereco,
    bairro = bairro,
    cep = cep,
    cidade = cidade,
    estado = estado
)
