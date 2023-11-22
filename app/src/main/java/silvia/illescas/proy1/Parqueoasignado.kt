package silvia.illescas.proy1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import silvia.illescas.proy1.ui.theme.Proy1Theme

class Parqueoasignado: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proy1Theme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ParqueoScreen()
                }
            }
        }
    }
}
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
                    text = stringResource(id = R.string.welcome_text),
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
                        text = stringResource(id = R.string.parking_text_template, parqueoText),
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
                    Text(text = stringResource(id = R.string.exit_button_text))
                }
            }
        }
    )
}
