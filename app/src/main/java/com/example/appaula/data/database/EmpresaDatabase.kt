package com.example.appaula.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import com.example.appaula.data.dao.ClienteDao
import com.example.appaula.data.model.Cliente

// Anotação do Room para Databases
// Lista das classes das Tabelas/Entidades; Versão desse Banco de Dados; Exportar/salvar em uma certa pasta o Schema/a Estrutura
@Database(entities = [Cliente::class], version = 1, exportSchema = false)
abstract class EmpresaDatabase : RoomDatabase()  // <- classe base para as Databases do Room
{
    abstract fun clienteDao(): ClienteDao  // <- função que retorna o Dao padrão da tabela cliente

    companion object {
        // Anotação que impede sobrescrita do valor da variável por diferentes contextos (racing condition)
        @Volatile
        // Guarda a instância global do banco de dados
        private var Instance: EmpresaDatabase? = null

        // Retorna a instância global caso não seja nula
        // Caso contrário, instancia um novo banco de dados
        // Isso impede multiplas instâncias do banco de dados ao decorrer da execução da aplicação
        fun getDatabase(context: Context): EmpresaDatabase {
            return Instance ?: synchronized(this) {
                // Contexto (provedor de recursos e serviços)
                // Classe do Banco de Dados (formato Java)
                // Nome do banco de dados
                Room.databaseBuilder(context, EmpresaDatabase::class.java, "empresa")
                    .fallbackToDestructiveMigration()  // Recria a estrutura do banco de dados caso não tenha uma anterior
                    .build()                           // Construir o Banco de Dados no sistema
                    .also { Instance = it }            // IMPORTANTE: Atribuir a instância atual à instância global
            }
        }
    }
}
