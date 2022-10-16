package com.example.dessertclicker.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dessertclicker.R
import com.example.dessertclicker.ui.theme.DessertClickerTheme

//средний блок экрана - фото дессерта, фон экрана
@Composable
fun DessertClickerMiddle(
    @DrawableRes dessertImageId: Int,
    onDessertClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.back),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(),

        ) {
            Image(
                painter = painterResource(dessertImageId),
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .align(Alignment.Center)
                    .clickable { onDessertClicked() },
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview
@Composable
fun DessertClickerMiddlePreview() {
    DessertClickerTheme {
        DessertClickerMiddle(
            dessertImageId = R.drawable.cupcake
        )
    }
}