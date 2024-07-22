package com.example.cleancodetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cleancodetest.Screens
import com.example.cleancodetest.UserViewModel

@Composable
fun ProductTestListScreen(
    navController: NavHostController,
    viewModel: UserViewModel,
) {
    val dataList by viewModel.mockedProducts.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
    ) {
        Button(onClick = { viewModel.getMockedProduct() }) {
            Text(text = "Get Mock")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(16.dp)
        ) {
            items(dataList) { product ->
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate(Screens.TestDetail.createRoute(product.id)) }
                ) {
                    Text(text = "ID: ${product.id}")
                    Text(text = "Title: ${product.title}")
                    Text(text = "Description: ${product.description}")
                    Text(text = "Category: ${product.category}")
                    Text(text = "Price: ${product.priсe}")
                }
            }
        }
    }
}