package com.example.proyectov50

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectov50.R

class ParqueoAsignado2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreenContent()
        }
    }
}

@Composable
fun BottomAppIcon(icon: ImageVector, contentDescription: String, phoneNumber: String, onClickAction: () -> Unit) {
    val context = LocalContext.current

    IconButton(
        onClick = onClickAction,
        modifier = Modifier.padding(25.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = icon, contentDescription = contentDescription)
            Text(text = contentDescription)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreenContent() {
    val phoneNumber = "50231105604"

    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.background(Color.Green)
            ) {
                BottomAppIcon(Icons.Default.Home, "Home", phoneNumber) {
                    // Lógica onClick para el botón Home
                }
                BottomAppIcon(Icons.Default.Place, "Place", phoneNumber) {
                    // Lógica onClick para el botón Place
                }
                BottomAppIcon(Icons.Default.AccountCircle, "Profile", phoneNumber) {
                    // Lógica onClick para el botón AccountCircle
                }
                BottomAppIcon(Icons.Default.Info, "Help", phoneNumber) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")

                    try {
                        context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        // WhatsApp no está instalado, muestra un mensaje de error o realiza alguna otra acción
                    }
                }
            }
        },
        content = {
            var name by remember { mutableStateOf("Jorge") }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF4CAF50)), // Fondo verde
                contentAlignment = Alignment.Center,
                content = {
                    Column(
                        modifier = Modifier
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(R.string.welcome_text, name),
                            fontSize = 24.sp,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .background(Color(0xFF9CCC65), CircleShape)
                                .padding(16.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            Image(
                                painter = painterResource(R.mipmap.commonqr_foreground),
                                contentDescription = "QR",
                                modifier = Modifier
                                    .size(200.dp)
                                    .wrapContentSize(Alignment.Center)
                            )
                        }
                    }
                }
            )
            }
        )
}