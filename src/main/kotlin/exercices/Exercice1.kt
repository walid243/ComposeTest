// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import model.Message

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac vestibulum nunc."
    val messages = listOf(
        Message("Marta Puig", body, "/generatedFace.png"),
        Message("Pere Puig", body, "/generatedFace2.png"),
        Message("Magmut Puig", body, "/generatedFace3.png")
    )
        LazyColumn {
            items(messages) { message ->
                Row(Modifier.padding(8.dp)) {
                    Image(painter = painterResource(message.imagePath), contentDescription = "image", modifier = Modifier.size(40.dp).clip(
                        CircleShape))
                    Spacer(Modifier.width(8.dp))
                    Column {
                        Text(message.author)
                        Spacer(Modifier.width(4.dp))
                        Text(message.body)
                    }
                }



            }
        }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
