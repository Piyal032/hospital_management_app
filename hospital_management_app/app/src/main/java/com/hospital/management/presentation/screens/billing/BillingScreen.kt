package com.hospital.management.presentation.screens.billing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
fun BillingScreen(
    navController: NavHostController
) {
    // Dummy bills
    val bills = listOf(
        Bill("B101", "Rahul Sharma", "P001", 15000.0, "paid", "2026-05-15"),
        Bill("B102", "Priya Patel", "P002", 5500.0, "pending", "2026-05-16"),
        Bill("B103", "Amit Kumar", "P003", 28000.0, "unpaid", "2026-05-14"),
        Bill("B104", "Sneha Gupta", "P004", 3200.0, "paid", "2026-05-15")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Billing & Invoices", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Primary, titleContentColor = Color.White, navigationIconContentColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).background(AppBackground).padding(16.dp)) {
            // Stats Row
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                BillingStatCard("Total Due", "₹33,500", EmergencyRed, Modifier.weight(1f))
                BillingStatCard("Received", "₹18,200", AvailableGreen, Modifier.weight(1f))
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(text = "Recent Invoices", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            
            Spacer(modifier = Modifier.height(12.dp))
            
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(bills) { bill ->
                    BillCard(bill)
                }
            }
        }
    }
}

@Composable
fun BillingStatCard(label: String, value: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = label, style = MaterialTheme.typography.labelSmall, color = color)
            Text(text = value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold, color = color)
        }
    }
}

@Composable
fun BillCard(bill: Bill) {
    val statusColor = when (bill.status) {
        "paid" -> AvailableGreen
        "pending" -> OccupiedOrange
        else -> EmergencyRed
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(48.dp).clip(CircleShape).background(Primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Receipt, contentDescription = null, tint = Primary)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = bill.patientName, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = "Bill ID: ${bill.id} • ${bill.date}", style = MaterialTheme.typography.bodySmall, color = TextSecondaryLight)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(text = "₹${bill.amount}", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = bill.status.uppercase(), style = MaterialTheme.typography.labelSmall, color = statusColor, fontWeight = FontWeight.Bold)
            }
        }
    }
}

data class Bill(val id: String, val patientName: String, val patientId: String, val amount: Double, val status: String, val date: String)
