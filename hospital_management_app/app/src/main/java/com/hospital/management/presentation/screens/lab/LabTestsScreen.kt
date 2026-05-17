package com.hospital.management.presentation.screens.lab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hospital.management.presentation.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabTestsScreen(
    navController: NavHostController
) {
    val tests = listOf(
        LabTest("T101", "Blood Routine", "P001", "Rahul Sharma", "Completed", "2026-05-15"),
        LabTest("T102", "ECG", "P003", "Amit Kumar", "Completed", "2026-05-15"),
        LabTest("T103", "X-Ray Chest", "P005", "Vikram Singh", "Pending", "2026-05-16"),
        LabTest("T104", "Urine Analysis", "P002", "Priya Patel", "In Progress", "2026-05-16")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Laboratory Tests", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Primary, titleContentColor = Color.White, navigationIconContentColor = Color.White)
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(AppBackground)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(tests) { test ->
                LabTestCard(test)
            }
        }
    }
}

@Composable
fun LabTestCard(test: LabTest) {
    val statusColor = when (test.status.lowercase()) {
        "completed" -> AvailableGreen
        "in progress" -> OccupiedOrange
        "pending" -> Warning
        else -> Color.Gray
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(48.dp).clip(RoundedCornerShape(8.dp)).background(Primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Science, contentDescription = null, tint = Primary)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = test.testName, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = "Patient: ${test.patientName}", style = MaterialTheme.typography.bodySmall, color = TextSecondaryLight)
                Text(text = "Date: ${test.date}", style = MaterialTheme.typography.labelSmall, color = TextSecondaryLight)
            }
            Surface(
                color = statusColor.copy(alpha = 0.1f),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = test.status,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = statusColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

data class LabTest(val id: String, val testName: String, val patientId: String, val patientName: String, val status: String, val date: String)
