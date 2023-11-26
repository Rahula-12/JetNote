package com.example.jetnote.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.jetnote.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDatabaseDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context,
        NoteDatabase::class.java,
        name="notes_db"
    ).fallbackToDestructiveMigration()
        .build()

}