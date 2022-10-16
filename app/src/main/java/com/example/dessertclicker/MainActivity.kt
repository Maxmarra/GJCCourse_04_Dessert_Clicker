package com.example.dessertclicker

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.ui.theme.DessertClickerTheme
import com.example.dessertclicker.ui.theme.DessertClickerApp

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate Called")

        setContent {
            DessertClickerTheme {
                DessertClickerApp(desserts = dessertList)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}

@Preview
@Composable
fun MyDessertClickerAppPreview() {
    DessertClickerTheme {
        DessertClickerApp(dessertList)
    }
}
