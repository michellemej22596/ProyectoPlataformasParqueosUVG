package silvia.illescas.proy1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import silvia.illescas.proy1.ui.theme.Proy1Theme
import kotlin.random.Random

class ParqueoAsignado : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proy1Theme() {
                Scaffold(
                    bottomBar = {
                        BottomAppBar(
                            modifier = Modifier.background(Color.Green)
                        ) {
                            BottomAppIcon(Icons.Default.Home, stringResource(R.string.home))
                            BottomAppIcon(Icons.Default.Place, stringResource(R.string.place))
                            BottomAppIcon(Icons.Default.AccountCircle, stringResource(R.string.profile))
                            BottomAppIcon(Icons.Default.Info, stringResource(R.string.help))
                        }
                    },
                    content = {
                        val navController = null
                        navController?.let { it1 -> ParqueoScreen(it1) }
                    }
                )
            }
        }
    }
}

private fun RowScope.BottomAppIcon(icon: ImageVector, contentDescription: String) {

}

@Composable
fun ParqueoScreen(navController: NavHostController) {
    val random = Random(System.currentTimeMillis())
    var parqueoText by remember { mutableStateOf("E" + random.nextInt(100)) }


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
                    onClick = {navController.navigate("ParqueoScreen2")},
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