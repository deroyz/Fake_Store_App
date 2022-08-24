package com.example.android.fakestoreapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.android.fakestoreapp.android.theme.FakeStoreAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FakeStoreAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    FakeStoreApplication()
                }
            }
        }
    }
}

@Composable
fun FakeStoreApplication(){
}
