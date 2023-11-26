package com.example.jetnote.data

import com.example.jetnote.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note:Note) = noteDatabaseDao.insertNote(note)
    suspend fun deleteNote(note: Note)=noteDatabaseDao.deleteNote(note)
    suspend fun getNoteById(id:String) = noteDatabaseDao.getNoteById(id)

    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAllNotes()

    suspend fun updateNote(note:Note) = noteDatabaseDao.updateNote(note)

    fun getAllNotes() = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}