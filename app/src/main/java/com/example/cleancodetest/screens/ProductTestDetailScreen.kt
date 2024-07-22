package com.example.cleancodetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cleancodetest.UserViewModel

@Composable
fun ProductTestDetailScreen(
    navController: NavHostController,
    viewModel: UserViewModel,
    productId: Int,
) {
    val data by viewModel.mockedProducts.observeAsState(emptyList())
    val product = data.find { it.id == productId }
//    val product = viewModel.getMockedProductById(productId)

    product?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(text = "ID: ${it.id}")
            Text(text = "Title: ${it.title}")
            Text(text = "Description: ${it.description}")
            Text(text = "Category: ${it.category}")
            Text(text = "Price: ${it.priсe}")

            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back")
            }
        }
    } ?: run {
        Text("Product not found")
    }
}