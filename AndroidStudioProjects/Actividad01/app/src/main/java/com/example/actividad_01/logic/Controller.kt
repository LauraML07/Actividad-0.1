package com.example.actividad_01.logic

import com.example.actividad_01.data.RepositorioCliente

class Controller {
    private val clientList: MutableList<Cliente> = RepositorioCliente.listClients.toMutableList()

    fun clientAddController(nuevoCliente: Cliente) {
        clientList.add(nuevoCliente)
    }

    fun clientDelController(id: Int): Boolean {
        return clientList.removeIf { it.id == id }
    }

    fun clientUpdateController(id: Int, name: String, surname: String, phone: String): Boolean {
        val cliente = clientList.find { it.id == id }
        return if (cliente != null) {
            cliente.name = name
            cliente.surname = surname
            cliente.phone = phone
            true
        } else {
            false
        }
    }

    fun showData(): String {
        val sb = StringBuilder()
        sb.append("\n--- LISTA ACTUAL DE CLIENTES (${clientList.size}) ---\n")
        clientList.forEach {
            sb.append("ID: ${it.id} | ${it.name} ${it.surname} | Tel: ${it.phone}\n")
        }
        return sb.toString()
    }
}