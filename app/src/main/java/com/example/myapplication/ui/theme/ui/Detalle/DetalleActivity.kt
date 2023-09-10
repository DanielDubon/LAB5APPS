package com.example.myapplication.ui.theme.ui.Detalle

import com.example.myapplication.R


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.navegacion.model.MyAppRoute
import com.example.myapplication.ui.theme.ui.CardItem
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


                }
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(cardItem: CardItem, modifier: Modifier = Modifier, navController: NavController) {

    Column(

        modifier = Modifier
            .background(color = Color(0xFFC1F160))
    ) {
        val context = LocalContext.current
        DetailCard(cardItem, navController)

    }


}

@Composable
fun DetailCard(cardItem: CardItem, navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth(),


    ) {
        Button(onClick = { navController.navigate(MyAppRoute.Home) }) {
            Text(text = "Back")
        }
        Image( painter = painterResource(id = cardItem.Image),
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
                text = cardItem.title,
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