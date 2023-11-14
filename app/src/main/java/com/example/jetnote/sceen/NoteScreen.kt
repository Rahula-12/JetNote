package com.example.jetnote.sceen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnote.R
import com.example.jetnote.components.NoteInputText
import com.example.jetnote.components.NotesButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen() {
    val title= remember {
        mutableStateOf("")
    }
    val description= remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.padding(
            6.dp
        )
    ) {
        TopAppBar(
            title = {
            Text(text = stringResource(R.string.app_name))
        },
            actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "App Icon")
        },
            colors= TopAppBarDefaults.largeTopAppBarColors(
                containerColor = Color.LightGray
            )
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                text = title.value,
                label = "Title",
                onTextChange = {
                    if(it.all { char->char.isLetter() || char.isWhitespace() }) title.value=it
                },
                modifier = Modifier.padding(
                    top=9.dp,
                    bottom = 8.dp
                )
            )
            NoteInputText(
                text = description.value,
                label = "Add Note",
                onTextChange = {
                    if(it.all { char->char.isLetter() || char.isWhitespace() }) description.value=it
                },
                modifier = Modifier.padding(
                    top=9.dp,
                    bottom = 8.dp
                ))
            NotesButton(
                text = "Save",
                onClick = {
                          if(title.value.isNotEmpty() && description.value.isNotEmpty()) {
                              title.value=""
                              description.value=""
                          }
                },
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}