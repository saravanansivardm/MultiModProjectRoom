package com.example.multimoduleapplication.localdata.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.multimoduleapplication.localdata.entity.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from notes_tbl")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * from notes_tbl where id =:id")
    suspend fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from notes_tbl")
    suspend fun deleteAllNotes()

    @Delete
    suspend fun deleteNote(note: Note)
}