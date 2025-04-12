package com.example.appaula.data

import android.content.Context
import com.example.appaula.data.database.EmpresaDatabase
import com.example.appaula.data.repository.ClientesRepository
import com.example.appaula.data.repository.OfflineClientesRepository

interface AppContainer {
    val clientesRepository: ClientesRepository
}

// Container para todos os repositórios
// "context" é baseado na referência da classe principal da aplicação (EmpresaApplication)
class AppDataContainer(private val context: Context): AppContainer {
    // instância do repositório offline da tabela clientes
    // "by lazy" adia a inicialização da variável até seu primeiro acesso
    override val clientesRepository: ClientesRepository by lazy {
        OfflineClientesRepository(EmpresaDatabase.getDatabase(context).clienteDao())
    }
}

// Nota: O contexto pode ser diferente mas, nesse caso, o ideal é usar a com maior tempo de vida
// "tempo de vida" é o quanto esse valor vai persistir na memória
// não se baseia em tempo, mas sim em linhas de execução e é relativo ao total de linhas do programa
// depende do nível de escopo do valor, onde o maior nível é o da classe principal da aplicação (conceito de heap, stack e RAII)
// isso pode ser mudado, com valores passando o tempo de vida da aplicação, usando Daemon Thread
