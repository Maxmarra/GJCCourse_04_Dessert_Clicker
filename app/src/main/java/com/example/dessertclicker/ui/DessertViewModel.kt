package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.data.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUiState())
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiState.asStateFlow()

    fun onDessertClicked(){

        _dessertUiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice,
                dessertsSold = dessertsSold,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }

    }


    /*
    * сначала в dessertIndex ноль
    * далее циклом перебераем и как только dessertsSold стало 5  и стало равное количеству 5 при индексе 1
    * в dessertIndex присваивается 1
    * идем дальше циклом - при  dessertsSold равном 5 количество из индекса 2 - равно 10
    * значит не проходим
    * выходим из цикла
    * в dessertIndex теперь 1
    * когда dessertsSold станет 10
    * индекс 2 пройдет по количеству и соответственно в dessertIndex присваивается 1
    * и тд.
    *
    * */
    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex  = index
            } else {
                break
            }
        }

        return dessertIndex
    }
}