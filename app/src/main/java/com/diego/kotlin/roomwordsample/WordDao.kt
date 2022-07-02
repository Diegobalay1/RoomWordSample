package com.diego.kotlin.roomwordsample

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * DAO: (Objeto de Acceso a los Datos)
 * Se especifican las búsquedas de SQL y se las asocia con llamadas de método.
 *
 * WordDao es una interfaz. Los DAO deber ser interfaces o clases abstractas.
 * La anotación @Dao lo identifica como una clase de DAO para Room.
 */
@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")//Busqueda que  muestra una lista de palabras ordenadas de forma ascendente.
    fun getAlphabetizedWords(): Flow<List<Word>>//Un flujo es una secuencia asíncrona de valores. Flow produce valores de a uno. Admite corrutinas en toda su API.

    @Insert(onConflict = OnConflictStrategy.IGNORE)//ignora palabra nueva si es exactamente la misma que una que ya esté en la lista
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")//consulta de SQL como parámetro de string para borrar todas las palabras.
    suspend fun deleteAll()

}