package com.example.dessertclicker.utils

import com.example.dessertclicker.model.Dessert

fun determineDessertToShow(desserts: List<Dessert>, dessertsSold: Int): Dessert {
    var dessertToShow = desserts.first()
    for (dessert in desserts) {
        if (dessertsSold >= dessert.startProductionAmount) {
            dessertToShow = dessert
        } else {
            break
        }
    }

    return dessertToShow
}