package com.cibertec.electricidad.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cibertec.electricidad.R
import com.cibertec.electricidad.data.ConsumoStore
import com.cibertec.electricidad.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {

    // TODO E02: validar cliente, consumo en kwh, Spinner y RadioButton; calcular con when o if else.
    // TODO E01: usar ConsumoHelper para insertar o actualizar y navegar a ConsumosActivity.

    private var _binding: FragmentRegistroBinding? = null
    private val binding get() = _binding!!

    private lateinit var consumoStore: ConsumoStore

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        consumoStore = ConsumoStore(requireContext().applicationContext)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarSpinnerArea()

        binding.buttonGuardar.setOnClickListener {
            guardar()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configurarSpinnerArea(){
        binding.spinnerCancha.adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.canchas,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        )
    }

    private fun obtenerSuministroSeleccionada(): String? {
        if (binding.spinnerCancha.selectedItemPosition == 0) return null
        return binding.spinnerCancha.selectedItem?.toString()
    }

    private fun obtenerConexionSeleccionada(): String? {
        return when (binding.radioGroupHorario.checkedRadioButtonId) {
            R.id.radioDiurno -> getString(R.string.diurno)
            R.id.radioNocturno -> getString(R.string.nocturno)
            else -> null
        }
    }

    private fun guardar() {
        val cliente = binding.editTextCliente.text.toString().trim()
        val kilovatios = binding.editTextKilovatios.toString()
        val conexion = obtenerConexionSeleccionada()
        val suministro = obtenerSuministroSeleccionada()


        binding.inputLayoutCliente.error = null
        binding.inputLayoutKilovatios.error = null
        binding.textViewErrorArea.visibility = View.GONE
        binding.textViewErrorPension.visibility = View.GONE

        var formularioValido = true

        if (cliente.isBlank()) {
            binding.editTextCliente.error = getString(R.string.error_nombre)
            formularioValido = false
        }

        if (kilovatios == null || kilovatios <= 0) {
            binding.inputLayoutKilovatios.error = getString(R.string.error_sueldo_base)
            formularioValido = false
        }



        if ( == null) {
            binding.textViewErrorArea.visibility = View.VISIBLE
            formularioValido = false
        }

        if ( == null) {
            binding.textViewErrorPension.visibility = View.VISIBLE
            formularioValido = false
        }

        if (!formularioValido || kilovatios == null || conexion == null || suministro == null) {
            return
        }

        val importeTotal = calcularImporteTotal(suministro, conexion)

        Thread {
            val idInsertado =
                consumoStore.agregar(cliente, kilovatios, conexion, suministro, , importeTotal = )
            activity?.runOnUiThread {
                if (_binding == null) return@runOnUiThread
                if (idInsertado == -1L) {
                    Toast.makeText(
                        requireContext(),
                        R.string.error_guardar_trabajador,
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    limpiarFormulario()
                    (activity as? MainActivity)?.abrirLista()
                }
            }
        }.start()

    }


}
