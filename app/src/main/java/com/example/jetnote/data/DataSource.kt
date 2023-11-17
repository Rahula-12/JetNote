package com.example.jetnote.data

import com.example.jetnote.model.Note

object DataSource {
    val notes:MutableList<Note> = mutableListOf(
        Note(title="Happy Holidays", description = "Spend holidays with family"),
        Note(title="Happy Diwali", description = "Spend Diwali with family") ,
        Note(title="Happy Bhaiya Dooj", description = "Spend Bhaiya Dooj with family")
    )
}