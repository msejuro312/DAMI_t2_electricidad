package com.cibertec.electricidad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.electricidad.databinding.ActivityMainBinding
import com.cibertec.electricidad.ui.RegistroFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.contenedorRegistro.id, RegistroFragment())
                .commit()
        }
    }
}
