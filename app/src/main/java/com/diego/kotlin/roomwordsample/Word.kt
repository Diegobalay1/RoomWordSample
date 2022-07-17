package com.diego.kotlin.roomwordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Cada clase @Entity representa una tabla SQLite.
 * @PrimaryKey: Cada entidad necesita una clave primaria.
 * @ColumnInfo(name = "word" ): especifica el nombre de la columna en la tabla.
 * Cada propiedad que se almacena en la base de datos debe tener visibilidad pública, que es..
 * ..el valor predeterminado de Kotlin.
 */
@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String,
                val description: String?)
