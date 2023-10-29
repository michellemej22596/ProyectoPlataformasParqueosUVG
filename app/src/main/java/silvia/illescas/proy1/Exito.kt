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
fun ExitoScreen() {
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
                    val painter = painterResource(id = R.drawable.cheque_background)
                    Icon(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth().height(1.dp)
                    )
                    Text(text = "¡Parqueo asignado con exito!")
                }
            },
            text = { Text(text = "Se ha asignado tu parqueo, puedes ir a parquearte de inmediato.") },
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
