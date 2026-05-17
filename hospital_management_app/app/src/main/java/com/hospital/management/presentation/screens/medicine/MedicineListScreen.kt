package com.hospital.management.presentation.screens.medicine

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
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hospital.management.data.model.Medicine
import com.hospital.management.presentation.components.*
import com.hospital.management.presentation.theme.*
import com.hospital.management.util.DummyDataProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicineListScreen(
    navController: NavHostController
) {
    val dummyDataProvider = remember { DummyDataProvider() }
    val medicines = remember { dummyDataProvider.getDummyMedicines() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Medicines", fontWeight = FontWeight.Bold) },
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
                .background(AppBackground)
                .padding(16.dp)
        ) {
            SearchBar(
                query = "",
                onQueryChange = { },
                placeholder = "Search medicines..."
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(medicines) { medicine ->
                    MedicineCard(medicine = medicine)
                }
            }
        }
    }
}

@Composable
fun MedicineCard(medicine: Medicine) {
    val stockColor = when {
        medicine.stock > 100 -> AvailableGreen
        medicine.stock > 50 -> Warning
        else -> EmergencyRed
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
                    .background(Primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Medication,
                    contentDescription = "Medicine",
                    tint = Primary
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = medicine.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${medicine.genericName} • ${medicine.category}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondaryLight
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${medicine.manufacturer} • Exp: ${medicine.expiryDate}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondaryLight
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "₹${medicine.price}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Stock: ${medicine.stock}",
                    style = MaterialTheme.typography.labelSmall,
                    color = stockColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
