package com.example.lab5v3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.example.lab5v3.ui.theme.Lab5v3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5v3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    P1()
}


@ExperimentalCoilApi
@Composable
fun P1() {

    Text(
        text = "TodoEventos",
        fontSize = 150.sp,
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp) ,

    )
    Text(
        text = "Your favorites",
        fontSize = 80.sp,
        modifier = Modifier.padding(top = 180.dp, bottom = 16.dp)

    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ImageWithText(
                    imageResId = R.drawable.flowers,
                    text = "Texto 1",
                    text2 = "SupportingText"
                )
                ImageWithText(
                    imageResId = R.drawable.shawn,
                    text = "Texto 2",
                    text2 = "SupportingText"

                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ImageWithText(
                    imageResId = R.drawable.selena,
                    text = "Texto 3",
                    text2 = "SupportingText"

                )
                ImageWithText(
                    imageResId = R.drawable.perfect,
                    text = "Texto 4",
                    text2 = "SupportingText"
                )


            }

        }
    }
    Text(
        text = "All Concerts",
        fontSize = 60.sp,
        modifier = Modifier.padding(top = 1650.dp, bottom = 16.dp)

    )

}

@Composable
fun ImageWithText(imageResId: Int, text: String, text2: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(500.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = text,
            fontSize = 50.sp,
            color = Color.Black,
        )
        Text(
            text = text2,
            fontSize = 50.sp,
            color = Color.Black,
        )
    }
}

fun P2() {
}


fun P3() {
}


fun P4() {
}

