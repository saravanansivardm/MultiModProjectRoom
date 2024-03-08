package com.example.multimoduleapplication.localdata.di

import android.content.Context
import androidx.room.Room
import com.example.multimoduleapplication.localdata.dao.NoteDatabaseDao
import com.example.multimoduleapplication.localdata.database.NoteDatabase
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
    fun provideDAO(noteDatabase: NoteDatabase): NoteDatabaseDao {
        return noteDatabase.noteDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "note_tbl"
        ).fallbackToDestructiveMigration().build()

}
