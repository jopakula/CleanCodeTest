package com.example.uikit.cleancodetest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserCard(
    user: User,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.LightGray)
            .padding(14.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = user.id.toString())
        Text(text = user.name ?: "")
        Text(text = user.email ?: "")
    }
}

@Composable
@Preview()
private fun UserCardPreview() {
    val user = User(
        id = 1,
        name = "name",
        email = "email",
    )
    UserCard(
        user = user
    )
}