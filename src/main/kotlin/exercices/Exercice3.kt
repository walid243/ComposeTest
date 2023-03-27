package exercices

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun WordList() {
    var list by remember { mutableStateOf(listOf<String>()) }
    var word by remember { mutableStateOf("") }
    Column {
    TextField(value = word, onValueChange = {
        word = it
    })
    Button(onClick = {
        if (word.isNotEmpty()){
            list += word
            word = ""
        }
    }){
        Text("Add to list")
    }
        LazyColumn {
            items(list){word ->
                Text(word)
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication){
        WordList()
    }
}