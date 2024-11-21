package com.example.georem.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReminderListScreen(
    reminders: List<String>, // reminder list from the inout screen
    onAddReminderClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //reminder list
        Column(modifier = Modifier.weight(1f)) {
            // Button to add reminder
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = onAddReminderClick) {
                    Text("Add New Reminder")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display reminders in a scrollable list, like the recycler view
            LazyColumn {
                items(reminders.size) { index ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(4.dp),
                    ) {
                        Text(
                            text = reminders[index],
                            modifier = Modifier.padding(16.dp),
                            fontSize = 18.sp
                        )
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