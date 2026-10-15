package com.cibertec.electricidad.data

import android.content.ContentValues
import android.content.Context
import com.cibertec.electricidad.model.Consumo


class ConsumoStore (context: Context) {
    private val dbHelper = ConsumoHelper(context.applicationContext)

    fun agregar(
        cliente: String,
        kilovatios: Int,
        suministro: String,
        conexion: String,
        importeTotal: Double
    ): Long {
        val valores = ContentValues().apply {
            put(ConsumoContrato.COLUMNA_CLIENTE, cliente)
            put(ConsumoContrato.COLUMNA_KILOVATIOS, kilovatios)
            put(ConsumoContrato.COLUMNA_SUMINISTRO, suministro)
            put(ConsumoContrato.COLUMNA_CONEXION, conexion)
            put(ConsumoContrato.COLUMNA_IMPORTE_TOTAL, importeTotal)
        }

        return dbHelper.writableDatabase.insert(
            ConsumoContrato.TABLA_CONSUMOS,
            null,
            valores
        )

    }

    fun obtenerTodas(): List<Consumo> {
        val consumos = mutableListOf<Consumo>()
        val columnas = arrayOf(
            ConsumoContrato.COLUMNA_ID,
            ConsumoContrato.COLUMNA_CLIENTE,
            ConsumoContrato.COLUMNA_KILOVATIOS,
            ConsumoContrato.COLUMNA_SUMINISTRO,
            ConsumoContrato.COLUMNA_CONEXION,
            ConsumoContrato.COLUMNA_IMPORTE_TOTAL
        )

        dbHelper.readableDatabase.query(
            ConsumoContrato.TABLA_CONSUMOS,
            columnas,
            null,
            null,
            null,
            null,
            "${ConsumoContrato.COLUMNA_ID} DESC").use { cursor ->
                val indiceId = cursor.getColumnIndexOrThrow(ConsumoContrato.COLUMNA_ID)
            val indiceCliente = cursor.getColumnIndexOrThrow(ConsumoContrato.COLUMNA_CLIENTE)
            val indiceKilovatios = cursor.getColumnIndexOrThrow(ConsumoContrato.COLUMNA_KILOVATIOS)
            val indiceSuministro = cursor.getColumnIndexOrThrow(ConsumoContrato.COLUMNA_SUMINISTRO)
            val indiceConexion = cursor.getColumnIndexOrThrow(ConsumoContrato.COLUMNA_CONEXION)
            val indiceImporteTotal = cursor.getColumnIndexOrThrow(ConsumoContrato.COLUMNA_IMPORTE_TOTAL)

            while (cursor.moveToNext()){
                consumos.add(
                    Consumo(
                        id = cursor.getInt(indiceId),
                        cliente = cursor.getString(indiceCliente),
                        kilovatios = cursor.getInt(indiceKilovatios),
                        suministro = cursor.getString(indiceSuministro),
                        conexion = cursor.getString(indiceConexion),
                        importeTotal = cursor.getDouble(indiceImporteTotal)

                    )
                )
            }

        }




        return consumos
    }

    fun actualizar(consumo: Consumo): Int {
        val valores = ContentValues().apply {
            put(ConsumoContrato.COLUMNA_CLIENTE, consumo.cliente)
            put(ConsumoContrato.COLUMNA_KILOVATIOS, consumo.kilovatios)
            put(ConsumoContrato.COLUMNA_SUMINISTRO, consumo.suministro)
            put(ConsumoContrato.COLUMNA_CONEXION, consumo.conexion)
            put(ConsumoContrato.COLUMNA_IMPORTE_TOTAL, consumo.importeTotal)



        }

        return dbHelper.writableDatabase.update(
            ConsumoContrato.TABLA_CONSUMOS,
            valores,
            "${ConsumoContrato.COLUMNA_ID} =?",
            arrayOf(consumo.id.toString())
        )
    }

    fun eliminar(id: Int): Int {
        return dbHelper.writableDatabase.delete(
            ConsumoContrato.TABLA_CONSUMOS,
            "${ConsumoContrato.COLUMNA_ID} =?",
            arrayOf(id.toString())

        )
    }
}


