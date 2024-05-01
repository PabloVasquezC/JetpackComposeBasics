package com.example.jetpackcomposetutorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme


private  val messages: List<MyMessage> = listOf(
    MyMessage(title = "Hola Jetpack Compose", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 2", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 3", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 4", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 5", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 6", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 7", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 8", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 9", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 10", body = "¿Preparado?"),
    MyMessage(title = "Hola Jetpack Compose 11", body = "¿Preparado?"),



)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                JetpackComposeTutorialTheme {
                    MyMessages(messages)
                }
            }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }


}




@Composable
fun MyComponent(message: MyMessage) {
    //each modifiers gonna make changes over the current element
    //and it returns is a new modifier
    Row(modifier = Modifier.padding(8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        "Fotografía",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)

    )
}

@Composable
fun MyTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            text = message.title,
            color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = message.body,
            color = MaterialTheme.colorScheme.background )
    }
}

@Composable
fun MyText(text: String, color: Color) {
    Text(text, color = color  )
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewComponent() {
    JetpackComposeTutorialTheme {
        MyMessages(messages)
    }

}