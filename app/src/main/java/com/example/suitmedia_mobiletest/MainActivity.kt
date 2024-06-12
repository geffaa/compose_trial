package com.example.suitmedia_mobiletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.suitmedia_mobiletest.domain.usecase.CheckPalindromeUseCase
import com.example.suitmedia_mobiletest.presentation.ui.screens.FirstScreen
import com.example.suitmedia_mobiletest.presentation.ui.screens.SecondScreen
import com.example.suitmedia_mobiletest.ui.theme.Suitmedia_mobiletestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val checkPalindromeUseCase = CheckPalindromeUseCase()

    Suitmedia_mobiletestTheme {
        NavHost(navController = navController, startDestination = "firstScreen") {
            composable("firstScreen") {
                FirstScreen(
                    navigateToSecondScreen = { navController.navigate("secondScreen") },
                    checkPalindromeUseCase = checkPalindromeUseCase
                )
            }
            composable("secondScreen") {
                SecondScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyApp()
}