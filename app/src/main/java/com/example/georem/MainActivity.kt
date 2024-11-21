package com.example.georem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.georem.ui.ReminderListScreen
import com.example.georem.ui.theme.ReminderInputScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    //state to hold reminders
    val reminders = remember { mutableStateOf(listOf<String>()) }

    NavHost(
        navController = navController,
        startDestination = "reminder_list" // Initial screen
    ) {
        //reminder List Screen
        composable("reminder_list") {
            ReminderListScreen(
                reminders = reminders.value,  // Pass reminders list
                onAddReminderClick = { navController.navigate("reminder_input") }
            )
        }

        // reminder input Screen
        composable("reminder_input") {
            ReminderInputScreen(
                onSaveClick = { reminder ->
                    reminders.value = reminders.value + reminder // Update list
                    navController.popBackStack() // Navigate back to reminder list
                },
                onCancelClick = { navController.popBackStack() } // Cancel and go back
            )
        }
    }
}