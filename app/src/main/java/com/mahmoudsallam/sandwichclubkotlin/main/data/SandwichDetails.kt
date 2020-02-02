package com.mahmoudsallam.sandwichclubkotlin.main.data

data class SandwichDetails(
    val description: String,
    val image: String,
    val ingredients: List<String>,
    val name: Name,
    val placeOfOrigin: String
)