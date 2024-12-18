package com.example.georem.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.georem.data.Reminder

@Composable
fun ReminderListScreen(
    reminders: List<Reminder>,
    onAddReminderClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = onAddReminderClick, modifier = Modifier.fillMaxWidth()) {
            Text("Add New Reminder")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Track expanded state for each reminder using a map of indices to booleans
        LazyColumn {
            items(reminders.size) { index ->
                var isExpanded by remember { mutableStateOf(false) }
                val reminder = reminders[index]

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { isExpanded = !isExpanded },  // Toggle expanded state
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = reminder.name,
                            fontSize = 18.sp
                        )

                        // Display additional details only if expanded
                        if (isExpanded) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Latitude: ${reminder.latitude}")
                            Text(text = "Longitude: ${reminder.longitude}")
                            Text(text = "Radius: ${reminder.radius} meters")
                            reminder.time?.let {
                                Text(text = "Time: $it")
                            }
                        }
                    }
                }
            }
        }
        // Map view
        MapScreen(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}