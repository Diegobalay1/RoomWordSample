package com.diego.kotlin.roomwordsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Room es una capa de base de datos sobre una base de datos SQLite.
 * Room se ocupa de las tareas rutinarias de las que solías encargarte con SQLiteOpenHelper.
 * Room usa el DAO para enviar consultas a su base de datos.
 * Room no permite enviar consultas en el subproceso principal.
 *   Con Flow, de manera automatica se ejecuta de manera asincrona en un subproceso, en segundo plano
 * Room proporciona comprobaciones de tiempo de compilación de las sentencias de SQLite.
 */

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract  fun wordDao(): WordDao

    companion object {
        // Singleton prevents multiple instances..
        // of database opening at the same time.
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}