package cl.douc.ejemploroom

import android.app.Application
import android.content.res.Configuration
import cl.douc.ejemploroom.repository.MensajeRepository

class MensajeApp: Application() {

    companion object{                   //Repositorio con su contexto
        lateinit var  repo: MensajeRepository
    }

    override fun onCreate() {
        super.onCreate()
        repo = MensajeRepository(this.applicationContext)

       }
    }




