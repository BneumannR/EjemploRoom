package cl.douc.ejemploroom.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cl.douc.ejemploroom.model.Mensaje
import cl.douc.ejemploroom.room.MensajeDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class MensajeRepository(var context: Context){

    var miDB = MensajeDataBase.getDatabase(context)

    fun agregar(mensaje:Mensaje)
    {
        CoroutineScope(IO).launch {     //corrutina de lectura y escritura
            miDB.mensajeDao().Agregar(mensaje)
        }

    }

    fun listar() : LiveData<List<Mensaje>>
    {
        return  miDB.mensajeDao().listar()
    }

}