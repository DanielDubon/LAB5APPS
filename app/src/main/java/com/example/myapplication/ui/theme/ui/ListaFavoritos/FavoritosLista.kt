package com.example.myapplication.ui.theme.ui.ListaFavoritos

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.events
import com.example.myapplication.ui.theme.ui.CardItem

@Composable
fun ListFavEvents(modifier: Modifier = Modifier) {





    LazyColumn {

        items(events) { places ->
            ListBox2(places)
        }
    }
}

@Composable
fun ListBox2(cardItem: CardItem){
    val context = LocalContext.current  // Obtiene el contexto local dentro de un composable
    val bitmapIMG = BitmapFactory.decodeResource(context.resources, R.drawable.dualipa)  // Reemplaza 'tu_imagen' con el nombre del recurso de imagen


    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Image(painter = painterResource(id = cardItem.Image),contentDescription = null,
            modifier = Modifier
                .padding(16.dp)
                .size(80.dp)
                .clip(CircleShape))

        Column() {
            Text(text = cardItem.title,
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(2.dp)

            )
            Text(text = cardItem.supText,
                fontSize = 10.sp,
            )

        }


        IconButton(
            modifier = Modifier.padding(16.dp),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Settings Icon"

            )
        }
    }
    Divider()
}
