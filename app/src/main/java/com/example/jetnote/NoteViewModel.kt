package com.example.jetnote

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnote.data.DataSource
import com.example.jetnote.data.NoteRepository
import com.example.jetnote.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository):ViewModel() {

    private val _noteList:MutableStateFlow<MutableList<Note>> = MutableStateFlow(mutableListOf())
    val noteList:StateFlow<MutableList<Note>> = _noteList

    init {
        viewModelScope.launch {
            repository.getAllNotes().distinctUntilChanged().collect{
                _noteList.value=it
            }
        }
    }
     fun addNote(note:Note) = viewModelScope.launch {  repository.addNote(note) }

     fun removeNote(note:Note) = viewModelScope.launch { repository.deleteNote(note) }

     fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

}