package com.example.jetnote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.jetnote.model.Note

@Dao
interface NoteDatabaseDao {
    @Query("Select * from notes_tbl")
    fun getNotes():List<Note>

    @Query("Select * from notes_tbl where id=:id")
    fun getNoteById(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note:Note)

    @Query("Delete from notes_tbl")
    fun deleteAllNotes()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note:Note)
}
