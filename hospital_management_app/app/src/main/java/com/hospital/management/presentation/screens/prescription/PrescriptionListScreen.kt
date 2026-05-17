package com.hospital.management.presentation.screens.prescription

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.hospital.management.data.model.Prescription
import com.hospital.management.presentation.navigation.Screen
import com.hospital.management.presentation.theme.*
import com.hospital.management.util.DummyDataProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrescriptionListScreen(
    navController: NavHostController,
    dummyDataProvider: DummyDataProvider = DummyDataProvider()
) {
    val prescriptions = remember { dummyDataProvider.getDummyPrescriptions() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Prescriptions", fontWeight = FontWeight.Bold) },
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
            items(prescriptions) { prescription ->
                PrescriptionCard(prescription) {
                    navController.navigate(Screen.PrescriptionDetail.createRoute(prescription.id))
                }
            }
        }
    }
}

@Composable
fun PrescriptionCard(prescription: Prescription, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardStrokeLight.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(48.dp).clip(CircleShape).background(Primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Medication, contentDescription = null, tint = Primary)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = prescription.patientName, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(text = "Diagnosis: ${prescription.diagnosis}", style = MaterialTheme.typography.bodySmall, color = TextSecondaryLight)
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(14.dp), tint = TextSecondaryLight)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = prescription.doctorName, style = MaterialTheme.typography.labelSmall, color = TextSecondaryLight)
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(text = prescription.createdAt, style = MaterialTheme.typography.labelSmall, color = Primary, fontWeight = FontWeight.Bold)
                IconButton(onClick = onClick) {
                    Icon(Icons.Default.ChevronRight, contentDescription = "View Details", tint = Color.Gray)
                }
            }
        }
    }
}
