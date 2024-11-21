package com.example.georem.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun ReminderInputScreen(
    onSaveClick: (String) -> Unit, // On save, pass the reminder to MainActivity
    onCancelClick: () -> Unit // On cancel, go back without saving
) {
    var newReminder by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        // Name (Reminder)
        OutlinedTextField(
            value = newReminder,
            onValueChange = { newReminder = it },
            label = { Text("Reminder") },
            modifier = Modifier.fillMaxWidth()
        )
        // Location (Optional)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Location (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )
        // Time (Optional)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Time (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )
        // Save Button
        Button(
            onClick = {
                if (newReminder.isNotBlank()) {
                    onSaveClick(newReminder) // Pass the reminder back
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Reminder")
        }

        // Cancel Button
        Button(
            onClick = onCancelClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel")
        }
    }
}