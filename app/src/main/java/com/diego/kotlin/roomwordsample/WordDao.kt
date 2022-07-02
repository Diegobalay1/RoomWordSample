package com.diego.kotlin.roomwordsample

import androidx.room.*

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
    fun getAlphabetizedWords(): List<Word>

    @Insert(onConflict = OnConflictStrategy.IGNORE)//ignora palabra nueva si es exactamente la misma que una que ya esté en la lista
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")//consulta de SQL como parámetro de string para borrar todas las palabras.
    suspend fun deleteAll()

}