package com.example.myapplication.Detalle

import ui.themePlaceList.Places

import com.example.myapplication.R


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ImageCard
import com.example.myapplication.ui.theme.CardItem
import com.example.myapplication.ui.theme.MyApplicationTheme


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

                    DetailScreen()
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier) {

    Column(

        modifier = Modifier
            .background(color = Color(0xFFC1F160))
    ) {
        val context = LocalContext.current
        DetailCard(CardItem(BitmapFactory.decodeResource(context.resources, R.drawable.evento1), "Concierto", "Dua lipa"))

    }


}

@Composable
fun DetailCard(cardItem: CardItem){
    Column(
        modifier = Modifier.fillMaxWidth(),


    ) {
        Image(bitmap = cardItem.Image.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()


        )
        Column(

            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(8.dp)
        ) {


            Text(text = "LA 12-1")
            Text(
                text = "Concierto Dua lipa",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Left,


            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                val image: Painter = painterResource(id = R.drawable.calendario)
                Icon(
                    painter = image,
                    contentDescription = "Calendario",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(3.dp)

                )

                Text(
                    text = "12 Agosto 2023",
                    textAlign = TextAlign.Left
                )

                Text(
                    text = "13:00",
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(2.dp)
                )
            }

            Text(
                text = "About",
                textAlign = TextAlign.Start,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(2.dp)
            )

            Text(
                text = "Ven y disfruta el concierto de Dua lipa, no te quedes sin disfrutar de esta experiencia inolvidable, escucha sus mejores canciones y de coreografias impresionantes",
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(2.dp)
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth()
            ) {
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(2.dp)
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Text(text = "Favorite")

                }

                Button(onClick = { /*TODO*/
                                 },
                    modifier = Modifier.padding(2.dp)
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Text(text = "Buy")
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {

    }
}