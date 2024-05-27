package com.rachmadhani.lafyuu_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rachmadhani.lafyuu_ui.CardFlashSale
import com.rachmadhani.lafyuu_ui.DataProduct
import com.rachmadhani.lafyuu_ui.DataProvider
import com.rachmadhani.lafyuu_ui.R

@Composable
fun FavoriteProductScreen(navController: NavHostController){
    val products : List<DataProduct> = remember { DataProvider.productList }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            }
            Text(
                text = "Favorite Product",
                color = Color.Black.copy(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(24.dp))
        FavoriteItems(products)
    }
}

@Composable
fun FavoriteItems(products : List<DataProduct>)
{
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),)
    {
        items(products) { product ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                CardFlashSale(navController = rememberNavController(), product)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoriteProductScreenPreview(){
    var navController = rememberNavController()
    FavoriteProductScreen(navController)
}