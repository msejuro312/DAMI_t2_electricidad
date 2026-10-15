package com.cibertec.electricidad.data

object ConsumoContrato {

    //usar id entero autogenerado, cliente, consumo en kwh, tipo de suministro, conexión y importe total.id entero autogenerado, cliente, consumo en kwh, tipo de suministro, conexión y importe total.

    const val TABLA_CONSUMOS = "consumos"
    const val COLUMNA_ID = "id"
    const val COLUMNA_CLIENTE = "cliente"
    const val COLUMNA_KILOVATIOS = "kilovatios"
    const val COLUMNA_SUMINISTRO = "suministro"
    const val COLUMNA_CONEXION = "conexion"
    const val COLUMNA_IMPORTE_TOTAL = "importeTotal"


    const val SQL_CREAR_TABLA = """
        CREATE TABLE $TABLA_CONSUMOS (            
            $COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMNA_CLIENTE TEXT NOT NULL,
            $COLUMNA_KILOVATIOS INTEGER NOT NULL,
            $COLUMNA_SUMINISTRO TEXT NOT NULL,
            $COLUMNA_CONEXION TEXT NOT NULL,
            $COLUMNA_IMPORTE_TOTAL REAL NOT NULL
        )
    """


}