package com.example.cleancodetest

sealed class Screens(
    val screen: String
) {
    data object List : Screens("list")
    data object Detail : Screens("detail/{productId}") {
        fun createRoute(productId: Int) = "detail/$productId"
    }
    data object TestList : Screens("test")
    data object TestDetail : Screens("test_detail/{productId}") {
        fun createRoute(productId: Int) = "test_detail/$productId"
    }
}