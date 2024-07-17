package com.pravas.ezshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.pravas.ezshop.data.SharedPreferencesManager
import com.pravas.ezshop.ui.navigation.NavGraph
import com.pravas.ezshop.ui.theme.EZshopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           EZshopTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val sharedPreferencesManager = SharedPreferencesManager(this)

                    val startDestination = if (sharedPreferencesManager.getToken() != null) {
                        "home"
                    } else {
                        "login"
                    }

                    NavGraph(navController = navController, context = this, startDestination = startDestination)
                }
            }
        }
    }
}
