package silvia.illescas.proy1
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.Face
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import silvia.illescas.proy1.ui.theme.Proy1Theme

class Perfil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proy1Theme(){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val navController = null
                    navController?.let { ProfileScreen(it) }
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Green box on top
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Color.Green)
            ) {
                Image(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(120.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "John Doe",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Profile information
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                ProfileCard(
                    icon = Icons.Sharp.Face,
                    title = "Personal Information",
                    items = listOf(
                        "Carrera: Ciencias de la Computación",
                        "Username: johndoe123",
                        "Carnet: 22596"
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileCard(
                    icon = Icons.Filled.ShoppingCart,
                    title = "Vehicle Information",
                    items = listOf(
                        "Model: Sedan",
                        "Plate: ABC123"
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ProfileCard(
    icon: ImageVector,
    title: String,
    items: List<String>
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    imageVector = icon,
                    contentDescription = "Icon",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(text = title, fontWeight = FontWeight.Bold)

                    items.forEach { item ->
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = item)
                    }
                }
            }
            }
        }
    @Composable
    fun BottomBarWithIconsAndIntent() {
        val phoneNumber = "50231105604"
        val context = LocalContext.current

        BottomAppBar(
            modifier = Modifier.background(Color.Green)
        ) {
            BottomAppIcon(Icons.Default.Home, stringResource(R.string.home), phoneNumber) {
                // Lógica onClick para el botón Home
            }
            BottomAppIcon(Icons.Default.Place, stringResource(R.string.place), phoneNumber) {
                // Lógica onClick para el botón Place
            }
            BottomAppIcon(Icons.Default.AccountCircle, stringResource(R.string.profile), phoneNumber) {
                // Lógica onClick para el botón AccountCircle
            }
            BottomAppIcon(Icons.Default.Info, stringResource(R.string.help), phoneNumber) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")

                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    // WhatsApp no está instalado, muestra un mensaje de error o realiza alguna otra acción
                }
                }
            }
    }
}