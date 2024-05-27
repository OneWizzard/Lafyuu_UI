package com.rachmadhani.lafyuu_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navController: NavHostController) {
    val products: List<DataProduct> = remember { DataProvider.productList }
    var search by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Header(navController)
        Spacer(modifier = Modifier.height(16.dp))

        // ImageHome
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("superFlashSale") }
        ) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .padding(16.dp)
                    .padding(vertical = 24.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Super Flash Sale\n50% off",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "08 : 34 : 55", color = Color.White, fontSize = 16.sp)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        // Category
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Category")
            Text(text = "More Category")
        }
        Spacer(modifier = Modifier.height(24.dp))
        CategoryHome()
        Spacer(modifier = Modifier.height(32.dp))

        // FlashSale
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Flash Sale")
            Text(text = "See More")
        }
        Spacer(modifier = Modifier.height(24.dp))
        FlashSaleHome(products)
        Spacer(modifier = Modifier.height(32.dp))

        // MegaSale
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Mega Sale")
            Text(text = "See More")
        }
        Spacer(modifier = Modifier.height(24.dp))
        FlashSaleHome(products) // Assuming Mega Sale uses the same structure as Flash Sale
        Spacer(modifier = Modifier.height(32.dp))

        // Recommended Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(64.dp))
                Text(
                    text = "Recommended Product",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "We recommended the best for you",
                    fontSize = 12.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Recommended Items
        RecommendedHome(products)
        Footer()
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun FlashSaleHome(products: List<DataProduct>) {
    LazyRow {
        items(products) { product ->
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CardFlashSale(navController = rememberNavController(),product)
            }
        }
    }
}

@Composable
fun CategoryHome() {
    var category = listOf(
        DataCategory("Category", R.drawable.figma),
        DataCategory("Category", R.drawable.figma),
        DataCategory("Category", R.drawable.figma),
        DataCategory("Category", R.drawable.figma),
        DataCategory("Category", R.drawable.figma),
        DataCategory("Category", R.drawable.figma),
        DataCategory("Category", R.drawable.figma)
    )

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(category) { category ->
            CardCategory(category)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun RecommendedHome(products: List<DataProduct>) {
    LazyVerticalGrid(
        modifier = Modifier.height(500.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(products) { product ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CardFlashSale(navController = rememberNavController(),product)
            }
        }
    }
}



