package com.example.jetnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnote.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {
    @Query("Select * from notes_tbl")
    fun getNotes(): Flow<MutableList<Note>>

    @Query("Select * from notes_tbl where id=:id")
    suspend fun getNoteById(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note:Note)

    @Query("Delete from notes_tbl")
    suspend fun deleteAllNotes()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note:Note)
}
