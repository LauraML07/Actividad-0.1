package com.example.actividad_01.data

import com.example.actividad_01.logic.Cliente

class RepositorioCliente {
    companion object {
        val listClients: List<Cliente> = listOf(
            Cliente(1, "Carlos", "García", "611223344"),
            Cliente(2, "Ana", "López", "622334455"),
            Cliente(3, "David", "Martínez", "633445566")
        )
    }
}