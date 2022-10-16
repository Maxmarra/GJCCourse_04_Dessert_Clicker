package com.example.dessertclicker.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import com.example.dessertclicker.utils.determineDessertToShow

//место где мы вызываем, собираем созданные компоненты
@Composable
fun DessertClickerApp(
    desserts: List<Dessert>
) {
    var revenue by remember { mutableStateOf(0) }
    var dessertsSold by remember { mutableStateOf(0) }

    //чтобы получить доступ к данным первого десерта
    val currentDessertIndex by remember { mutableStateOf(0) }

    //получаем цену и id картинки у первого десерта
    //дальше в коде уже будем получать непосредственно десерт
    //и у него вызывать свойства цены и id картинки уже без индекса
    var currentDessertPrice by remember { mutableStateOf(desserts[currentDessertIndex].price) }
    var currentDessertImageId by remember { mutableStateOf(desserts[currentDessertIndex].imageId) }

    Scaffold(
        topBar = {
            AppBar()
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box (modifier = Modifier.weight(1F)){
                DessertClickerMain(

                    dessertImageId = currentDessertImageId,
                    onDessertClicked = {
                        // Update the revenue
                        revenue += currentDessertPrice
                        dessertsSold++

                        // Show the next dessert
                        val dessertToShow = determineDessertToShow(desserts, dessertsSold)
                        currentDessertImageId = dessertToShow.imageId
                        currentDessertPrice = dessertToShow.price
                    },
                    modifier = Modifier.padding(contentPadding)
                )
            }

            TransactionInfo(revenue = revenue, dessertsSold = dessertsSold)
        }

    }
}

@Preview
@Composable
fun DessertClickerAppPreview() {
    DessertClickerTheme {
        DessertClickerApp(desserts = Datasource.dessertList)
    }
}