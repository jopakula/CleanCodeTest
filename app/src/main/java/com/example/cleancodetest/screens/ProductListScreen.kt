package com.example.cleancodetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cleancodetest.Screens
import com.example.cleancodetest.UserViewModel
import com.example.cleancodetest.domain.models.UserDomainModel


@Composable
fun ProductListScreen(navController: NavHostController, viewModel: UserViewModel) {
    val data by viewModel.data.observeAsState()
    val dataList by viewModel.dataList.observeAsState(emptyList())
    var id by remember { mutableStateOf("") }
    val user by viewModel.user.observeAsState()
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Button(onClick =  { navController.navigate(Screens.TestList.screen) }) {
            
        }
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") })
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") })
        Button(onClick = {
            viewModel.saveUser(UserDomainModel(firstName, lastName))
        }) {
            Text(text = "Save User")
        }
        Button(onClick = { viewModel.getUser() }) {
            Text(text = "Get User")
        }
        user?.let {
            Text(text = "First Name: ${it.nameFirst}")
            Text(text = "Last Name: ${it.nameLast}")
        }
        TextField(value = id, onValueChange = { id = it })
        Button(onClick = { viewModel.fetchDataById(id.toInt()) }) {
            Text(text = "fetch one")
        }
        data?.let {
            Text(text = "ID: ${it.id}")
            Text(text = "Title: ${it.title}")
            Text(text = "Description: ${it.description}")
            Text(text = "Category: ${it.category}")
            Text(text = "Price: ${it.priсe}")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.fetchDataList() }) {
            Text(text = "Fetch list")
        }

        LazyColumn {
            items(dataList) { product ->
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate(Screens.Detail.createRoute(product.id)) }
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