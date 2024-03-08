package com.example.multimoduleapplication.localdata.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.multimoduleapplication.localdata.dao.NoteDatabaseDao
import com.example.multimoduleapplication.localdata.entity.Note


@Database(
    entities = [Note::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2,
            spec = NoteDatabase.Migration1To2::class
        ),
        AutoMigration(
            from = 2,
            to = 3,
            spec = NoteDatabase.Migration2To3::class
        ),
    ]
)
abstract class NoteDatabase : RoomDatabase() {
    @RenameColumn(
        tableName = "notes_tbl",
        fromColumnName = "title",
        toColumnName = "migration_title"
    )
    class Migration1To2 : AutoMigrationSpec

    @RenameColumn(
        tableName = "notes_tbl",
        fromColumnName = "description",
        toColumnName = "migration_description"
    )
    class Migration2To3 : AutoMigrationSpec

    abstract fun noteDao(): NoteDatabaseDao
}