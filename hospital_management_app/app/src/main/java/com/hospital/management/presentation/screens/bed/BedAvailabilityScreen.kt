package com.hospital.management.presentation.screens.bed

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
import com.hospital.management.data.model.Bed
import com.hospital.management.presentation.components.*
import com.hospital.management.presentation.theme.*
import com.hospital.management.util.DummyDataProvider
import com.hospital.management.util.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BedAvailabilityScreen(
    navController: NavHostController
) {
    val dummyDataProvider = remember { DummyDataProvider() }
    val beds = remember { dummyDataProvider.getDummyBeds() }
    val availableCount = beds.count { it.status == "available" }
    val occupiedCount = beds.count { it.status == "occupied" }
    val maintenanceCount = beds.count { it.status == "maintenance" }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bed Availability", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Primary, titleContentColor = Color.White)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Summary Cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                BedSummaryCard(
                    title = "Available",
                    count = availableCount,
                    color = AvailableGreen,
                    modifier = Modifier.weight(1f)
                )
                BedSummaryCard(
                    title = "Occupied",
                    count = occupiedCount,
                    color = OccupiedOrange,
                    modifier = Modifier.weight(1f)
                )
                BedSummaryCard(
                    title = "Maintenance",
                    count = maintenanceCount,
                    color = MaintenanceYellow,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "All Beds",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(beds) { bed ->
                    BedCard(bed = bed)
                }
            }
        }
    }
}

@Composable
fun BedSummaryCard(
    title: String,
    count: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = color
            )
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondaryLight
            )
        }
    }
}

@Composable
fun BedCard(bed: Bed) {
    val statusColor = when (bed.status) {
        "available" -> AvailableGreen
        "occupied" -> OccupiedOrange
        "maintenance" -> MaintenanceYellow
        else -> TextSecondaryLight
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(statusColor.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Bed,
                    contentDescription = "Bed",
                    tint = statusColor
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Ward ${bed.wardNumber} - Bed ${bed.bedNumber}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${bed.type} • ${bed.department} • Floor ${bed.floor}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondaryLight
                )
                if (bed.patientName != null) {
                    Text(
                        text = "Patient: ${bed.patientName}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Primary
                    )
                }
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(statusColor.copy(alpha = 0.2f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = bed.status.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = statusColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
