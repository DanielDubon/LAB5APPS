package com.example.myapplication.ui.theme.ui.themePlaceList

import com.example.myapplication.R


import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.ui.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListPlaces()
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListPlaces(modifier: Modifier = Modifier) {


    val places = listOf(
        Places("Dua Lipa La", "LA Hall 12-12"),
                Places("Dua Lipa WS", "WS ST 22-1"),
                 Places("Dua Lipa GUA", "GUA CT CY1")

    )


    LazyColumn {

        items(places) { places ->
            ListBox(places)
        }
    }
}

@Composable
fun ListBox(places: Places){
    val context = LocalContext.current  // Obtiene el contexto local dentro de un composable
    val bitmapIMG = BitmapFactory.decodeResource(context.resources, R.drawable.dualipa)  // Reemplaza 'tu_imagen' con el nombre del recurso de imagen


    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Image(
            bitmap = bitmapIMG.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .size(80.dp)
                .clip(CircleShape)

        )

        Column() {
            Text(text = places.title,
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(2.dp)

            )
            Text(text = places.direction,
                    fontSize = 10.sp,
            )

        }


        IconButton(
            modifier = Modifier.padding(16.dp),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Settings Icon"

            )
        }
    }
    Divider()
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {

    }
}