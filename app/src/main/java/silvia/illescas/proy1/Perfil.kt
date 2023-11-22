package silvia.illescas.proy1

import silvia.illescas.proy1.ui.theme.Proy1Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

class Perfil: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proy1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ProfileFun()
                }
            }
        }
    }
}

@Composable
fun ProfileFun(modifier: Modifier = Modifier) {
    Surface(color = Color.White) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // Top Icon and Text
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = stringResource(R.string.profile),
                    modifier = modifier.size(250.dp)
                )

                Text(
                    text = stringResource(R.string.user_name),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    modifier = Modifier
                )

                Text(text = "" )

                Divider(color = Color.LightGray, modifier = Modifier.padding(vertical = 16.dp))
            }

            // Sections of the screen, calling ProfileItem method
            ProfileItem(
                iconResId = R.drawable.person_foreground,
                textResId = R.string.edit_profile
            )

            Divider(color = Color.LightGray, modifier = Modifier.padding(vertical = 16.dp))

            ProfileItem(
                iconResId = R.drawable.lock_foreground,
                textResId = R.string.my_password
            )

            Divider(color = Color.LightGray, modifier = Modifier.padding(vertical = 16.dp))

            ProfileItem(
                iconResId = R.drawable.notifications_foreground,
                textResId = R.string.notifications
            )

            Divider(color = Color.LightGray, modifier = Modifier.padding(vertical = 16.dp))

            ProfileItem(
                iconResId = R.mipmap.commonqr_foreground,
                textResId = R.string.my_favorites
            )

            Divider(color = Color.LightGray, modifier = Modifier.padding(vertical = 16.dp))

        }
    }
}

@Composable
fun ProfileItem(iconResId: Int, textResId: Int, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = iconResId),
                contentDescription = stringResource(textResId),
                modifier = modifier.size(60.dp).wrapContentSize(Alignment.Center)
            )

            Column {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = stringResource(textResId), fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.width(120.dp))

            Image(
                painter = painterResource(id = R.drawable.arrow_foreground),
                contentDescription = stringResource(textResId),
                modifier = modifier.size(40.dp).wrapContentSize(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Proy1Theme {
        ProfileFun()
    }
}



