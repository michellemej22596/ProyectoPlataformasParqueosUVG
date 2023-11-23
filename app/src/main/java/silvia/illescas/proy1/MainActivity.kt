
package silvia.illescas.proy1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import silvia.illescas.proy1.ui.theme.Proy1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Proy1Theme {
                NavHost(navController = navController, startDestination = "loginScreen") {
                    composable("loginScreen") { LoginScreen(navController) }
                    composable("registrationScreen") { RegistrationScreen(navController) }
                    composable("ParqueoScreen") { ParqueoScreen(navController) }
                    composable("ParqueoScreen2") { MyScreenContent(navController) }
                    composable("Profile") { ProfileScreen(navController) }
                    composable("error") { Error() }
                    composable("exito") { Exito() }
                }
            }
        }
    }


}
