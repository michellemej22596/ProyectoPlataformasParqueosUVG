package silvia.illescas.proy1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ParqueoScreen() {
    var parqueoText by remember { mutableStateOf("E09") }

    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF4CAF50)), // Fondo verde
        contentAlignment = Alignment.Center,
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Bienvenido",
                    fontSize = 24.sp,
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .background(Color(0xFF9CCC65), CircleShape)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "Tu parqueo es: $parqueoText",
                        fontSize = 24.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* Acción al hacer clic en el botón "Marcar Salida" */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Text(text = "Marcar Salida")
                }
            }
        }
    )
}
