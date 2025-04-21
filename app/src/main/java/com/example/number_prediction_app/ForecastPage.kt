package com.example.number_prediction_app

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random


@Composable
fun ForecastPage( navController: NavController) {
    val tfForecast= remember { mutableStateOf("") }
    val rightToForecast= remember { mutableStateOf(5) }
    val randomNumber= remember { mutableStateOf(0)  }
    val info= remember { mutableStateOf("") }

    Column(
        modifier= Modifier.fillMaxSize(),
        Arrangement.SpaceEvenly,
        Alignment.CenterHorizontally,
    ) {
        LaunchedEffect(key1 = true) {
            randomNumber.value=Random.nextInt(101)
            Log.e("Rasgele sayı",randomNumber.value.toString())
        }
        Text(text = "Kalan Hak : ${rightToForecast.value}", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım : ${info.value}", fontSize = 24.sp, )
        TextField(value = tfForecast.value, onValueChange = {
            tfForecast.value=it
        },
            label = { Text(text = "Tahmin") }
            )
        Button(
            onClick = {
                rightToForecast.value=rightToForecast.value -1
                val forecast=tfForecast.value.toInt()
                if (randomNumber.value==forecast){
                    navController.navigate("result_page/true"){
                        popUpTo("Forecast_page"){
                            inclusive=true
                        }
                    }
                    return@Button
                }
                if (randomNumber.value>forecast){
                    info.value="Arttır"
                }
                if (randomNumber.value<forecast){
                    info.value="Azalt"
                }
                if (rightToForecast.value==0){
                    navController.navigate("result_page/false"){
                        popUpTo("Forecast_page"){
                            inclusive=true
                        }
                    }
                }
                tfForecast.value=""

            },
            modifier = Modifier.size(250.dp,50.dp)
        ) {
            Text(text = "TAHMİN ET")
        }
    }
}