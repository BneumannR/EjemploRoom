package cl.douc.ejemploroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.douc.ejemploroom.R
import cl.douc.ejemploroom.databinding.ItemLayoutBinding
import cl.douc.ejemploroom.model.Mensaje

class MensajeAdapter() : RecyclerView.Adapter<MensajeAdapter.MensajeHolder>() {

    var lista:List<Mensaje> = ArrayList()

    class MensajeHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        fun binData(mensaje: Mensaje)
        {
            val binding = ItemLayoutBinding.bind(view)
            with(binding)
            {
                lblMensaje.text = mensaje.contenido
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensajeHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return  MensajeHolder(v)
       // TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return lista.size

      //  TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MensajeHolder, position: Int) {
       // TODO("Not yet implemented")
        holder.binData(lista[position])
    }

    fun setMensaje(mensajes:List<Mensaje>)
    {
        lista = mensajes
        notifyDataSetChanged()
    }


}