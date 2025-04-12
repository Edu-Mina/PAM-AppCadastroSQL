package com.example.appaula.data.repository

import com.example.appaula.data.model.Cliente
import kotlinx.coroutines.flow.Flow

// Interface/Molde para os tipos diversos de repositórios provenientes
// "Repositório" é uma parte intermediária que esconde a complexidade de como os dados são adquiridos, armazenados e manipulados
interface ClientesRepository {
    fun getAllClientesStream(): Flow<List<Cliente>>

    fun getClientesStream(id: Int): Flow<Cliente?>

    // suspend fun upsertCliente(cliente: Cliente)

    suspend fun insertCliente(cliente: Cliente)

    suspend fun updateCliente(cliente: Cliente)

    suspend fun deleteCliente(cliente: Cliente)
}
