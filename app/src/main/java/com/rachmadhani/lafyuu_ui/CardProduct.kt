package com.rachmadhani.lafyuu_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.rachmadhani.lafyuu_ui.DataProduct
import com.rachmadhani.lafyuu_ui.DataProvider

@Composable
fun CardFlashSale(navController: NavHostController, product: DataProduct) {

    Column(
        modifier = Modifier
            .padding(4.dp)
            .border(2.dp, color = Color.Magenta, shape = RoundedCornerShape(10)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column {
            Text(text = product.name)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.currentPrice, fontSize = 16.sp)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = product.normalPrice, fontSize = 12.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = product.discount, fontSize = 12.sp)
        }
    }
}