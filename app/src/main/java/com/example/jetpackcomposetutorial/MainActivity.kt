package com.example.jetpackcomposetutorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme


private  val messages: List<MyMessage> = listOf(
    MyMessage(title = "Hola Jetpack Compose", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae urna ullamcorper, sollicitudin ante nec, fermentum nisl. Maecenas non metus vel felis blandit bibendum."),
    MyMessage(title = "Hola Jetpack Compose 2", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage(title = "Hola Jetpack Compose 3", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage(title = "Hola Jetpack Compose 4", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage(title = "Hola Jetpack Compose 5", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
    MyMessage(title = "Hola Jetpack Compose 6", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum vitae urna ullamcorper, sollicitudin ante nec, fermentum nisl. Maecenas non metus vel felis blandit bibendum. Nullam risus justo, pulvinar non enim sed, fermentum sodales sapien."),
    MyMessage(title = "Hola Jetpack Compose 7", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur pellentesque neque eget diam posuere porta. Quisque ut nulla at nunc vehicula lacinia. Proin adipiscing porta tellus, ut feugiat nibh adipiscing sit amet."),
    MyMessage(title = "Hola Jetpack Compose 8", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum."),
    MyMessage(title = "Hola Jetpack Compose 9", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem."),
    MyMessage(title = "Hola Jetpack Compose 10", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras justo odio, dapibus ac facilisis in, egestas eget quam."),
    MyMessage(title = "Hola Jetpack Compose 11", body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.")



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

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(start = 8.dp)
                           .clickable {
                               expanded = !expanded
                           }
    ) {
        MyText(
            text = message.title,
            color = MaterialTheme.colorScheme.primary,
            lines = 1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            text = message.body,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            if (expanded) Int.MAX_VALUE else 1

        )
    }
}

@Composable
fun MyText(text: String, color: Color, lines: Int) {
    Text(text, color = color, maxLines =  lines)
}


@Preview(uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewComponent() {

        MyMessages(messages)


}