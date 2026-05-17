package com.hospital.management.presentation.screens.prescription

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hospital.management.presentation.theme.Primary
import com.hospital.management.presentation.theme.PrimaryDark
import com.hospital.management.presentation.theme.AppBackground
import com.hospital.management.presentation.theme.Secondary
import com.hospital.management.presentation.theme.TextPrimaryLight
import com.hospital.management.presentation.theme.TextSecondaryLight
import com.hospital.management.presentation.theme.Info
import com.hospital.management.presentation.theme.CardStrokeLight
import com.hospital.management.presentation.theme.DividerLight
import com.hospital.management.util.DummyDataProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrescriptionDetailScreen(
    navController: NavHostController, 
    prescriptionId: String,
    dummyDataProvider: DummyDataProvider = DummyDataProvider()
) {
    val prescription = remember { dummyDataProvider.getDummyPrescriptions().find { it.id == prescriptionId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Prescription Details", fontWeight = FontWeight.ExtraBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        if (prescription == null) {
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.Center) {
                Text("Prescription not found")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(AppBackground)
                    .verticalScroll(rememberScrollState())
            ) {
                // Header with Patient Info
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Primary, PrimaryDark)
                            )
                        )
                        .padding(24.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Person, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(text = prescription.patientName, color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                                Text(text = "Patient ID: ${prescription.patientId}", color = Color.White.copy(alpha = 0.8f), style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    // Doctor & Date Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        InfoCard(
                            label = "Doctor",
                            value = prescription.doctorName,
                            icon = Icons.Default.MedicalServices,
                            modifier = Modifier.weight(1f)
                        )
                        InfoCard(
                            label = "Date",
                            value = prescription.createdAt,
                            icon = Icons.Default.Event,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Diagnosis Section
                    SectionHeader("Diagnosis")
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, CardStrokeLight.copy(alpha = 0.5f))
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.HealthAndSafety, contentDescription = null, tint = Secondary, modifier = Modifier.size(24.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = prescription.diagnosis, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold, color = TextPrimaryLight)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Medicines Section
                    SectionHeader("Medicines")
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, CardStrokeLight.copy(alpha = 0.5f))
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            prescription.medicines.split("\n").forEach { medicine ->
                                if (medicine.isNotBlank()) {
                                    Row(
                                        modifier = Modifier.padding(vertical = 6.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Icon(Icons.Default.Medication, contentDescription = null, tint = Primary, modifier = Modifier.size(18.dp).padding(top = 2.dp))
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(text = medicine, style = MaterialTheme.typography.bodyMedium, color = TextPrimaryLight)
                                    }
                                    Divider(color = DividerLight)
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Instructions Section
                    SectionHeader("Special Instructions")
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Primary.copy(alpha = 0.05f)),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Primary.copy(alpha = 0.1f))
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = prescription.instructions ?: "No specific instructions provided.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = PrimaryDark,
                                lineHeight = 22.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Follow-up Alert
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Info.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.NotificationsActive, contentDescription = null, tint = Info)
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(text = "Follow-up Visit", style = MaterialTheme.typography.labelSmall, color = Info)
                                Text(text = prescription.followUpDate ?: "Not scheduled", fontWeight = FontWeight.Bold, color = Info)
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = TextPrimaryLight,
        modifier = Modifier.padding(bottom = 12.dp, start = 4.dp)
    )
}

@Composable
fun InfoCard(label: String, value: String, icon: androidx.compose.ui.graphics.vector.ImageVector, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardStrokeLight.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(icon, contentDescription = null, tint = Primary, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = label, style = MaterialTheme.typography.labelSmall, color = TextSecondaryLight)
            Text(text = value, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = TextPrimaryLight)
        }
    }
}
