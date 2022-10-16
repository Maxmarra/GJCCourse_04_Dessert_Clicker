package com.example.dessertclicker.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import com.example.dessertclicker.ui.theme.DessertClickerTheme
import com.example.dessertclicker.utils.determineDessertToShow

//место где мы вызываем, собираем созданные компоненты
@Composable
fun DessertClickerApp(
    viewModel: DessertViewModel = viewModel()
) {
    val uiState by viewModel.dessertUiState.collectAsState()
    Scaffold(
        topBar = {
            AppBarTop()
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier.fillMaxSize(),

        ) {
            Box (modifier = Modifier.weight(1F)){
                DessertClickerMiddle(
                    dessertImageId = uiState.currentDessertImageId,
                    onDessertClicked = {
                       viewModel.onDessertClicked()
                    },
                    modifier = Modifier.padding(contentPadding)
                )
            }

            TransactionInfoBottom(
                revenue = uiState.revenue,
                dessertsSold = uiState.dessertsSold)
        }

    }
}

@Preview
@Composable
fun DessertClickerAppPreview() {
    DessertClickerTheme {
        DessertClickerApp()
    }
}