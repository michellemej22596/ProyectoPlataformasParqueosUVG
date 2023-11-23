package com.example.proyectov50


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import silvia.illescas.proy1.ui.theme.Proy1Theme


class Exito: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proy1Theme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ExitoScreen()
                }
            }
        }
    }
}
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
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val painter = painterResource(id = R.drawable.cheque_foreground)
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.size(45.dp),
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth().height(1.dp)
                    )
                    Text(text = stringResource(id = R.string.success_text))
                }
            },
            text = { Text(text = stringResource(id = R.string.success_message)) },
            confirmButton = {
                Button(
                    onClick = { showDialog = false },
                    shape = MaterialTheme.shapes.small,
                    modifier = Modifier.fillMaxWidth().background(Color(139, 195, 74, 255)),
                ) {
                    Text(text = stringResource(id = R.string.success_close_button), color = Color.White)
                }
            }
        )
    }
}
