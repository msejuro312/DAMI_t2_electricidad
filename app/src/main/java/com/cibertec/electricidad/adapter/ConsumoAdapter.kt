package com.cibertec.electricidad.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.electricidad.databinding.ItemReservaBinding
import com.cibertec.electricidad.model.Consumo

class ConsumoAdapter(
    private val electricidad: MutableList<Consumo>
) : RecyclerView.Adapter<ConsumoAdapter.ViewHolder>() {

    class ViewHolder(
        val binding: ItemReservaBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemReservaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO E03: mostrar el total y los datos auxiliares de la reserva.
    }

    override fun getItemCount(): Int = electricidad.size
}
