package com.cibertec.electricidad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cibertec.electricidad.databinding.FragmentReservasBinding

class ConsumosFragment : Fragment() {

    // TODO E03: cargar RecyclerView/CardView con datos del helper.
    // TODO E04: usar ItemTouchHelper: derecha edita, izquierda elimina.

    private var _binding: FragmentReservasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
