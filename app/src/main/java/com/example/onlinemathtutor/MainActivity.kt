package com.example.onlinemathtutor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.onlinemathtutor.ui.theme.OnlineMathTutorTheme
import com.example.onlinemathtutor.Screens.Registration
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onlinemathtutor.Screens.MainScreen
import com.example.onlinemathtutor.Screens.ProfileScreen
import com.example.onlinemathtutor.Screens.ChatScreen
import com.example.onlinemathtutor.Screens.CheckProfile
import com.example.onlinemathtutor.Screens.TasksScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            OnlineMathTutorTheme {
                NavHost(navController = navController, startDestination = "registrationScreen") {
                    composable("registrationScreen") { Registration(navController) }
                    composable("mainScreen") { MainScreen(navController) }
                    composable("profileScreen") { // Экран профиля
                        ProfileScreen(navController)
                    }
                    composable("chatScreen") { ChatScreen(navController) }
                    composable("checkProfile") { CheckProfile(navController) }
                    composable("tasksScreen") { TasksScreen(navController) }

                }
            }
        }
    }
}



