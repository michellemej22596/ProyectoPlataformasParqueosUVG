package silvia.illescas.proy1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import silvia.illescas.proy1.ui.theme.Proy1Theme

class Registration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proy1Theme(){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = null
                    navController?.let { RegistrationScreen(it) }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavHostController) {
    var username by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = Icons.Filled.AccountBox,
            contentDescription = "Account Icon",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(R.string.username)) },
            modifier = Modifier.fillMaxWidth(),
            isError = !username.text.contains("@") // Validación del usuario
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = !password.text.matches(Regex("^[a-zA-Z0-9]+$")) // Validación de la contraseña
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(stringResource(R.string.confirm_password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = !confirmPassword.text.matches(Regex("^[a-zA-Z0-9]+$")) // Validación de la contraseña
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Acción de registro
                if (username.text.contains("@") && password.text == confirmPassword.text) {
                    navController.navigate("loginScreen")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            enabled = username.text.contains("@") && password.text == confirmPassword.text // Habilitar botón solo si el usuario y la contraseña son válidos
        ) {
            Text("Registrarse")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.no_account),
            modifier = Modifier.clickable {
                navController.navigate("loginScreen")
            }
            )
        }
}