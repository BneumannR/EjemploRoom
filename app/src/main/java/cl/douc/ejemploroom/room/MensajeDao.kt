package cl.douc.ejemploroom.room

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.douc.ejemploroom.model.Mensaje

@Dao
interface MensajeDao {

    @Insert
    suspend fun Agregar(mensaje: Mensaje)

    @Delete
    fun delete(mensaje:Mensaje )

    @Update
    fun actualizar(mensaje: Mensaje)

    @Query("select id, contenido from mensaje_table")
    fun listar(): LiveData<List<Mensaje>>           //tb podria ser ---> suspend fun listar

//    @Query("select id, contenido from mensaje_table order by contenido")  //ORDENA LA LISTA DEL RECYCLERvIEW POR ALFABETO
//    fun listar(): LiveData<List<Mensaje>>

    @Query("select id, contenido from mensaje_table where id = :id")
    fun buscar (id:Int) : LiveData<Mensaje>

}