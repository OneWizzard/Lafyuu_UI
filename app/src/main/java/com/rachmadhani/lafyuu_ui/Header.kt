package com.rachmadhani.lafyuu_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Header(navController: NavController) {
    var search by remember { mutableStateOf("") }

    Row(modifier = Modifier
        .padding(vertical = 8.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier
                .padding(vertical = 24.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            label = { Text(text = "Search") }
        )
        IconButton(onClick = { navController.navigate("favorite") }) {
            Icon(Icons.Default.Favorite, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.Notifications, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeader(){
    var navController = rememberNavController()
    Header(navController)
}