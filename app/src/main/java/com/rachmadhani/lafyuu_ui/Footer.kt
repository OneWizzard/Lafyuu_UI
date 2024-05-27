package com.rachmadhani.lafyuu_ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rachmadhani.lafyuu_ui.DataIconFooter

@Composable
fun Footer() {
    var icons = listOf(
        DataIconFooter(Icons.Default.Home, "Home"),
        DataIconFooter(Icons.Default.Search, "Explore"),
        DataIconFooter(Icons.Default.ShoppingCart, "Cart"),
        DataIconFooter(Icons.Default.Star, "Offer"),
        DataIconFooter(Icons.Default.Person, "Account"),
    )

    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .border(2.dp, color = Color.Red, shape = RoundedCornerShape(10)),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        items(icons) { icons ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(4.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(icons.Image, contentDescription = icons.name)
                }
                Text(text = icons.name, fontSize = (12.sp))
            }
        }
    }

}