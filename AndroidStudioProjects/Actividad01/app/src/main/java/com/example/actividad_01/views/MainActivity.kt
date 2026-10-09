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
            val msg = "[LAMBDA] Cliente insertado -> ID: $id | $name $surname | Tel: $phone"
            Log.d(LOG_TAG, msg)
            printConsoleData()
        },
        onUpdateCustomer = { id, name, surname, phone ->
            val modificado = appController.clientUpdateController(id, name, surname, phone)
            val msg = if (modificado) {
                "[LAMBDA] Cliente ID: $id modificado -> Nuevo: $name $surname | Tel: $phone"
            } else {
                "[LAMBDA] No encontrado ID: $id para modificar"
            }
            Log.d(LOG_TAG, msg)
            printConsoleData()
        },
        onDeleteCustomer = { id ->
            val borrado = appController.clientDelController(id)
            val msg = if (borrado) {
                "[LAMBDA] Cliente ID: $id eliminado con éxito"
            } else {
                "[LAMBDA] No encontrado ID: $id para eliminar"
            }
            Log.d(LOG_TAG, msg)
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
        btnModify = findViewById(R.id.myButtonEdit)  // Cambiado: Button con n
        btnRemove = findViewById(R.id.myButtonDel)   // Cambiado: Button con n

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