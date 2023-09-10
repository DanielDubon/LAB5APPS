package com.example.myapplication.ui.theme.ui.Perfil



import com.example.myapplication.R


import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
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

                    Profile()
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Profile(modifier: Modifier = Modifier) {

    Column(
            modifier = Modifier
            .background(color = Color(0xFFC1F160))
    ) {
        val context = LocalContext.current
        Perfil(Userprofile("Dua Lipa",BitmapFactory.decodeResource(context.resources, R.drawable.dualipa) ,BitmapFactory.decodeResource(context.resources, R.drawable.evento1)))

    }


}

@Composable
fun Perfil(userprofile: Userprofile){
    Box(
        contentAlignment = Alignment.Center ,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)

    ) {

        Image(
            bitmap = userprofile.CoverPic.asImageBitmap() ,
            contentDescription = "Cover Picture",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Surface(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .padding(16.dp),
            shape = CircleShape,


            ) {
            Image(
                bitmap = userprofile.ProfilePic.asImageBitmap(),
                contentDescription = "Profile Picture",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }


        Text(
            text = userprofile.Name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = androidx.compose.ui.graphics.Color.White,
            modifier = Modifier
                .padding(2.dp)
        )
    }
    }

    Column() {


        val context = LocalContext.current  // Obtiene el contexto local dentro de un composable
        val bitmapIMGPerfil = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.iconusuarioperfil
        )

        val bitmapIMGCandado = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.candado
        )

        val bitmapIMGNotificaciones = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.notificacion
        )

        val bitmapIMGFavoritos = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.favorito
        )

//INICIA ROW DE AJUSTES PERFIL
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Image(
                bitmap = bitmapIMGPerfil.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(60.dp)
                    .clip(CircleShape)

            )

            Column() {
                Text(
                    text = "Editar Perfil",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp)

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

//INICIA ROW DE CONTRASEÑA
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Image(
                bitmap = bitmapIMGCandado.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(60.dp)

            )

            Column() {
                Text(
                    text = "Ajustes privacidad",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp)

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

//INICIA ROW DE NOTIFICACIONES
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Image(
                bitmap = bitmapIMGNotificaciones.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(60.dp)

            )

            Column() {
                Text(
                    text = "Notificaciones",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp)

                )


            }

            val isNotificationsEnabled = remember { mutableStateOf(true) }
            Switch(
                modifier = Modifier.padding(16.dp),
                checked = isNotificationsEnabled.value,
                onCheckedChange = { isChecked ->
                    isNotificationsEnabled.value = isChecked
                }
            )






        }
        Divider()


        //INICIA ROW DE FAVORITOS
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Image(
                bitmap = bitmapIMGFavoritos.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .size(60.dp)

            )

            Column() {
                Text(
                    text = "Favoritos",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp)

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


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {

    }
}