package com.example.georem.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.georem.data.Reminder
import com.example.georem.ui.MapScreen

@Composable
fun ReminderInputScreen(
    onSaveClick: (Reminder) -> Unit, // Pass Reminder object on save
    onCancelClick: () -> Unit // On cancel, return to list screen
) {
    var name by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var radius by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        // Name (Reminder)
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Latitude
        OutlinedTextField(
            value = latitude,
            onValueChange = { latitude = it },
            label = { Text("Latitude") },
            modifier = Modifier.fillMaxWidth()
        )

        // Longitude
        OutlinedTextField(
            value = longitude,
            onValueChange = { longitude = it },
            label = { Text("Longitude") },
            modifier = Modifier.fillMaxWidth()
        )

        // Radius
        OutlinedTextField(
            value = radius,
            onValueChange = { radius = it },
            label = { Text("Radius (meters)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Optional Time
        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Save Button
        Button(
            onClick = {
                if (name.isNotBlank() && latitude.isNotBlank() && longitude.isNotBlank() && radius.isNotBlank()) {
                    onSaveClick(
                        Reminder(
                            name = name,
                            latitude = latitude.toDouble(),
                            longitude = longitude.toDouble(),
                            radius = radius.toFloat(),
                            time = time.toLongOrNull() // Handles optional time
                        )
                    )
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

        // Map view
        MapScreen(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}