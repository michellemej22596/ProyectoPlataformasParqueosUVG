package silvia.illescas.proy1


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable


@Composable
fun ErrorScreen() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            shape = MaterialTheme.shapes.medium,
            title = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val painter = painterResource(id = R.drawable.exclamacion1_foreground)
                    Icon(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth().height(1.dp)
                    )
                    Text(text = "Error")
                }
            },
            text = { Text(text = "Se ha producido un error al escanear el QR, vuelva a intentarlo.") },
            confirmButton = {
                Button(
                    onClick = { showDialog = false },
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.fillMaxWidth().background(Color(3, 121, 255)),
                ) {
                    Text("Cerrar", color = Color.White)
                }
            }
        )
    }
}
