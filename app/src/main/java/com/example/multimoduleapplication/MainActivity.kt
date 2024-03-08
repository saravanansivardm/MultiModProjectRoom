package com.example.multimoduleapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.multimoduleapplication.screen.NoteAppHomeScreen
import com.example.multimoduleapplication.theme.MultiModuleApplicationTheme
import com.example.multimoduleapplication.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleApplicationTheme {
                val notesViewModel: NoteViewModel by viewModels()
                NotesApp(notesViewModel)
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel) {
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteAppHomeScreen(
        notes = notesList,
        onRemoveNote = { noteViewModel.removeNote(it) },
        onAddNote = { noteViewModel.addNote(it) },
    )
}

