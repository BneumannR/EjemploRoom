package cl.douc.ejemploroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.douc.ejemploroom.model.Mensaje


@Database(entities = [Mensaje::class], version = 1)
abstract class MensajeDataBase: RoomDatabase(){

    abstract  fun mensajeDao():MensajeDao

    companion object{
        @Volatile
        private  var INSTANCE: MensajeDataBase? = null

        fun getDatabase(context: Context): MensajeDataBase  // (TODO) --> programacion SINGLETON, solo una instancia en una memoria a la vez, una sola conexion
        {
            if (INSTANCE == null)
            {
                synchronized(this)  //SYNCHRONIZED para decirle literal que hay solo una a la vez,ejemplo dos consultas a la vez, se ponen  cola y pasa una la vez
                {
                    INSTANCE = Room.databaseBuilder(context, MensajeDataBase::class.java, "mensaje_db").build()

                }
            }
            return INSTANCE!!
        }
    }
}