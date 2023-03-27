package exercices

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun App() {
    val counter = remember { mutableStateOf(0) }
    Row {
        Button(onClick = {
            counter.value +=1
        }) {
            Text("+1")
        }
        Text(counter.value.toString())
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication){
        App()
    }
}