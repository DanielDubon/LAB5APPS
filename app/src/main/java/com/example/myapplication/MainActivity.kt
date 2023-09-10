package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.Image

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.ui.Detalle.DetailScreen
import com.example.myapplication.ui.theme.ui.ListaFavoritos.ListFavEvents
import com.example.myapplication.navegacion.model.MyAppNavigationActions
import com.example.myapplication.navegacion.model.MyAppRoute
import com.example.myapplication.navegacion.model.MyAppTopLevelDestination
import com.example.myapplication.navegacion.model.TOP_LEVEL_DESTINATIONS
import com.example.myapplication.ui.theme.ui.Perfil.Profile
import com.example.myapplication.ui.theme.ui.CardItem
import com.example.myapplication.ui.theme.ui.MyApplicationTheme
import com.example.myapplication.ui.theme.ui.themePlaceList.ListPlaces


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
                    val navController = rememberNavController()
                    val navigateAction = remember(navController){
                        MyAppNavigationActions(navController)
                    }
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val selectedDestination = navBackStackEntry?.destination?.route?: MyAppRoute.Home

                    MyAppContent(
                        navController = navController,
                        selectedDestination = selectedDestination,
                        navigaeTopLevelDestination =navigateAction::navigateTo
                    )
                    //EventGrid()
                }
            }
        }
    }
}

@Composable
fun BottonNavigation(selectedDestination: String,
                        navigateLevel: (MyAppTopLevelDestination) -> Unit
){

    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        TOP_LEVEL_DESTINATIONS.forEach { destinations ->
             NavigationBarItem(selected = selectedDestination == destinations.route,
                 onClick = { navigateLevel(destinations) },

                 icon = {
                    Icon( imageVector = destinations.selectedIcon,
                        contentDescription = stringResource(id = destinations.iconTextId) )

                 }

             )


        }
    }

}

@Composable
fun MyAppContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination: String,
    navigaeTopLevelDestination: (MyAppTopLevelDestination) -> Unit
){
    Row(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
        NavHost(
            modifier = modifier.weight(1f),
            navController = navController, startDestination = MyAppRoute.Home ){
            composable(MyAppRoute.Home){
                EventGrid(modifier, navController)
            }
            composable(MyAppRoute.Favorites){
                ListFavEvents()           }
            composable(MyAppRoute.Places){
            ListPlaces()
            }
            composable(MyAppRoute.Profile){
            Profile()
            }
            fun findEventById(eventId: String?): CardItem? {
                return events.firstOrNull { it.id == eventId }
            }
            composable(MyAppRoute.Detail){ backStackEntry ->
                val eventId = backStackEntry.arguments?.getString("eventId")
                val cardItem = findEventById(eventId)
                if (cardItem != null) {
                    DetailScreen(cardItem,modifier,navController)
                } else {
                    Log.d("ERROR", "Entramos al ELSE , carditem es NULL")
                }

            }


            ////////////////////////////////////////////



        }
            BottonNavigation(selectedDestination = selectedDestination, navigateLevel = navigaeTopLevelDestination)
            
        }
    }

}
val events = listOf(
    CardItem("1",R.drawable.evento1, "Concierto", "Dua lipa"),
    CardItem("2", R.drawable.eventoteatro1, "Teatro", "Obra graciosa"),
    CardItem("3",R.drawable.eventodisco1, "Disco", "Musica Tecno"),
    CardItem("4", R.drawable.buffet, "Buffet" , "Comida Gourmet")
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventGrid(modifier: Modifier = Modifier,navController: NavHostController) {

    val scope = rememberCoroutineScope()



    val context = LocalContext.current




    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Your Favorites",
            modifier = Modifier.padding(2.dp),
            style = MaterialTheme.typography.headlineLarge
        )


        LazyVerticalGrid(

            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = modifier
        ) {


            items(events) { cardItem ->
                ImageCard(cardItem, navController)
            }
    }


     //2

        Text(text = "All Concerts",
            modifier = Modifier.padding(2.dp),
            style = MaterialTheme.typography.headlineLarge
        )


        LazyVerticalGrid(

            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            modifier = modifier
        ) {


            items(events) { cardItem ->
                ImageCard(cardItem, navController)
            }
        }



    }
}




@Composable
fun ImageCard(cardItem: CardItem, navController: NavController) {

    Surface(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth(0.5f)
            .aspectRatio(1f)
            .clickable {
                navController.navigate("detalle/${cardItem.id}")
                Log.d("CARD ITEM ID", cardItem.id)
            },

    ) {
        Column(
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .background(color = Color(0xFFC1F160))
        ) {
            Image(
                painter = painterResource(id = cardItem.Image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )


            Text(
                text = cardItem.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = cardItem.supText,
                fontSize = 14.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {

    }
}