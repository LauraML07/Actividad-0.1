package com.example.actividad_01.views

class Dialog(
    private val onAddCustomer: (id: Int, name: String, surname: String, phone: String) -> Unit,
    private val onUpdateCustomer: (id: Int, name: String, surname: String, phone: String) -> Unit,
    private val onDeleteCustomer: (id: Int) -> Unit
) {
    fun show(actionType: Int) {
        when (actionType) {
            0 -> {
                val randomId = (10..99).random()
                onAddCustomer(randomId, "Laura Lambda", "Martínez", "654112233")
            }
            1 -> {
                val targetId = (1..3).random()
                onUpdateCustomer(targetId, "Laura Edit Lambda", "García", "677889900")
            }
            2 -> {
                val targetId = (1..3).random()
                onDeleteCustomer(targetId)
            }
        }
    }
}