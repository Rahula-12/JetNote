package com.example.jetnote

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.jetnote.data.DataSource
import com.example.jetnote.model.Note

class NoteViewModel:ViewModel() {

    private val noteList=mutableStateListOf<Note>()

    init {
        noteList.addAll(DataSource.notes)
    }
    fun addNote(note:Note) {
        noteList.add(note)
    }

    fun removeNote(note:Note) {
        noteList.remove(note)
    }

    fun getAllNotes():MutableList<Note> {
        return noteList
    }

}