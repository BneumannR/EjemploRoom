package cl.douc.ejemploroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.douc.ejemploroom.MensajeApp
import cl.douc.ejemploroom.model.Mensaje
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    var mensajes : LiveData<List<Mensaje>>? = null

    init {
        mensajes = MensajeApp.repo.listar()
    }

    fun onAgregarClicked(mensaje: Mensaje){

        MensajeApp.repo.agregar(mensaje)
    }


}