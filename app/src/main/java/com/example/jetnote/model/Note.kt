package com.example.jetnote.model

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    val id:UUID=UUID.randomUUID(),
    @ColumnInfo(name = "notes_title")
    val title: String,
    @ColumnInfo(name="notes_description")
    val description:String,
    @ColumnInfo(name="notes_entryDate")
    val entryDate:Date= Date.from(Instant.now())
)
