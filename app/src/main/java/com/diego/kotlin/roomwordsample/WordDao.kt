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

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

}