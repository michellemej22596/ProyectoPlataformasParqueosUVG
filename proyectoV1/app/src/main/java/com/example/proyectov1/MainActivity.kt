package com.example.proyectov1

import android.annotation.SuppressLint
import android.content.Context
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreenContent()
        }
    }
}

@Composable
fun BottomAppIcon(icon: ImageVector, contentDescription: String) {
    IconButton(
        onClick = {
            openWhatsAppChat()
        },
        modifier = Modifier
            .padding(25.dp),
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


private fun shareOrder(context: Context, subject: String, summary: String) {
    // Intent a WhatsApp
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.new_cupcake_order)
        )
    )
}

fun openWhatsAppChat() {
    val phoneNumber = "50231105604"
    val uri = Uri.parse("https://wa.me/$phoneNumber")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    //startActivity(intent, null)
    Context.startService(intent)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScreenContent() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.background(Color.Green)
            ) {
                BottomAppIcon(Icons.Default.Home, "Home")
                BottomAppIcon(Icons.Default.Place, "Place")
                BottomAppIcon(Icons.Default.AccountCircle, "Profile")
                BottomAppIcon(Icons.Default.Info, "Help")
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
                            text = "Bienvenido $name",
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
