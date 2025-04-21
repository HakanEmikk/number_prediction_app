package com.example.number_prediction_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.number_prediction_app.ui.theme.Number_prediction_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Number_prediction_appTheme {
                navigation( )
            }
        }
    }
}

@Composable
fun navigation( ) {
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = "home_page") {
        composable(route="home_page") {
            HomePage(navController)
        }
        composable(route="result_page/{result}",
            arguments = listOf(
                navArgument("result"){type=NavType.BoolType}
            )
        ) {
            val  result=it.arguments?.getBoolean("result")!!
            ResultPage(result = result)
        }
        composable(route="forecast_page") {
            ForecastPage(navController)
        }
    }
}

@Composable
fun HomePage( navController: NavController) {
    Column(
        modifier=Modifier.fillMaxSize(),
        Arrangement.SpaceEvenly,
        Alignment.CenterHorizontally,
    ) {
        Text(text = "Tahmin Oyunu", fontSize = 36.sp)
        Image(painter = painterResource(id = R.drawable.dice_image), contentDescription = "")
        Button(
            onClick = {
                navController.navigate("forecast_page")
            },
            modifier = Modifier.size(250.dp,50.dp)
        ) {
            Text(text = "OYUNA BAŞLA")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Number_prediction_appTheme {

    }
}