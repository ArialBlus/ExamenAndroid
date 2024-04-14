import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListContent()
        }
    }
}

@Composable
fun TodoListContent() {
    var todoText by remember { mutableStateOf("") }
    var todoItems by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = todoText,
            onValueChange = { todoText = it },
            label = { Text("Nueva tarea") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (todoText.isNotBlank()) {
                    todoItems = todoItems + todoText
                    todoText = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Agregar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            todoItems.forEach { todo ->
                Text(todo)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoListContent()
}
