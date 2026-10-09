package com.example.actividad_01.views

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.actividad_01.R
import com.example.actividad_01.logic.Cliente
import com.example.actividad_01.logic.Controller

class MainActivity : AppCompatActivity() {

    private lateinit var btnRegister: ImageView
    private lateinit var btnModify: ImageView
    private lateinit var btnRemove: ImageView

    private val appController = Controller()

    private val customDialog = Dialog(
        onAddCustomer = { id, name, surname, phone ->
            val nuevo = Cliente(id, name, surname, phone)
            appController.clientAddController(nuevo)
            Log.d(LOG_TAG, "Cliente añadido: ID $id - $name $surname, Tel: $phone")
            printConsoleData()
        },
        onUpdateCustomer = { id, name, surname, phone ->
            val modificado = appController.clientUpdateController(id, name, surname, phone)
            if (modificado) {
                Log.d(LOG_TAG, "Cliente modificado: ID $id")
            } else {
                Log.d(LOG_TAG, "Error: no se encontró al cliente con ID $id")
            }
            printConsoleData()
        },
        onDeleteCustomer = { id ->
            val borrado = appController.clientDelController(id)
            if (borrado) {
                Log.d(LOG_TAG, "Cliente borrado (ID: $id)")
            } else {
                Log.d(LOG_TAG, "No se pudo borrar, el ID $id no existe")
            }
            printConsoleData()
        }
    )

    companion object {
        const val LOG_TAG = "=== REGISTRO_APP ==="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWorkflow()
    }

    private fun initWorkflow() {
        btnRegister = findViewById(R.id.myButtonAdd)
        btnModify = findViewById(R.id.myButtonEdit)
        btnRemove = findViewById(R.id.myButtonDel)

        btnRegister.setOnClickListener {
            customDialog.show(0)
        }

        btnModify.setOnClickListener {
            customDialog.show(1)
        }

        btnRemove.setOnClickListener {
            customDialog.show(2)
        }
    }

    private fun printConsoleData() {
        val dataOutput = appController.showData()
        Log.d(LOG_TAG, dataOutput)
    }
}