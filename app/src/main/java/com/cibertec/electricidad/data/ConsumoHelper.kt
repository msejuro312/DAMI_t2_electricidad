package com.cibertec.electricidad.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConsumoHelper(context: Context) : SQLiteOpenHelper(
    context,
    "electricidad.db",
    null,
    1
) {

    override fun onCreate(db: SQLiteDatabase) {
        // TODO E01: crear la tabla electricidad.
        db.execSQL(ConsumoContrato.SQL_CREAR_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // TODO E01: actualizar la estructura cuando cambie la versión de la base de datos.
    }

    // TODO E01: implementar insertar(reserva), listar(), actualizar(reserva) y eliminar(id).
}
