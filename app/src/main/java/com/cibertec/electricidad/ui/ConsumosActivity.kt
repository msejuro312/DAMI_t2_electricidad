package com.cibertec.electricidad.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.electricidad.databinding.ActivityReservasBinding

class ConsumosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReservasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.contenedorReservas.id, ConsumosFragment())
                .commit()
        }
    }
}
