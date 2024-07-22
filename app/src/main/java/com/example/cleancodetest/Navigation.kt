package com.example.cleancodetest

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cleancodetest.screens.ProductDetailScreen
import com.example.cleancodetest.screens.ProductListScreen
import com.example.cleancodetest.screens.ProductTestDetailScreen
import com.example.cleancodetest.screens.ProductTestListScreen

@Composable
fun Navigation(
    navigationController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    viewModel: UserViewModel,
) {
    NavHost(
        navController = navigationController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screens.List.screen) {
            ProductListScreen(
                navController = navigationController,
                viewModel = viewModel,
            )
        }
        composable(
            route = Screens.Detail.screen,
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            productId?.let {
                ProductDetailScreen(navController = navigationController, viewModel, it)
            }
        }

        composable(Screens.TestList.screen) {
            ProductTestListScreen(
                navController = navigationController,
                viewModel = viewModel
            )
        }
        composable(
            route = Screens.TestDetail.screen,
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            productId?.let {
                ProductTestDetailScreen(navController = navigationController, viewModel, it)
            }
        }

    }
}
