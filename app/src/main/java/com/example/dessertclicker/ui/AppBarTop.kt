package com.example.dessertclicker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dessertclicker.R
import com.example.dessertclicker.ui.theme.DessertClickerTheme

//верхний блок - панель приложения
@Composable
fun AppBarTop(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6,
        )
    }
}

@Preview
@Composable
fun AppBarAppPreview() {
    DessertClickerTheme {
        AppBarTop()
    }
}