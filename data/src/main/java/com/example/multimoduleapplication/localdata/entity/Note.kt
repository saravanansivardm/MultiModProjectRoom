package com.example.multimoduleapplication.localdata.entity


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "notes_tbl")
class Note @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "migration_title")
    val title: String,

    @ColumnInfo(name = "migration_description")
    val description: String,
)