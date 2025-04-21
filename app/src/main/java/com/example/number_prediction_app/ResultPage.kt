package com.example.number_prediction_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultPage(result:Boolean ) {
    Column(
        modifier= Modifier.fillMaxSize(),
        Arrangement.SpaceEvenly,
        Alignment.CenterHorizontally,
    ) {
        if (result)
        {
            Text(text = "Kazandınız", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.happy_image), contentDescription = "")

        }else{
            Text(text = "Kaybettiniz", fontSize = 36.sp)
            Image(painter = painterResource(id = R.drawable.sad_image), contentDescription = "")
        }



    }
}