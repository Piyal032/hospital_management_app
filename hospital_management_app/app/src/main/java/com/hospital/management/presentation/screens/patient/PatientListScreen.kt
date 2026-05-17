package com.hospital.management.presentation.screens.patient

import androidx.compose.foundation.clickable
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hospital.management.data.model.Patient
import com.hospital.management.presentation.components.*
import com.hospital.management.presentation.navigation.Screen
import com.hospital.management.presentation.theme.*
import com.hospital.management.presentation.viewmodel.PatientViewModel
import com.hospital.management.util.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientListScreen(
    navController: NavHostController,
    viewModel: PatientViewModel = hiltViewModel()
) {
    val patientsState by viewModel.patients.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Patients", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Primary, titleContentColor = Color.White)
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddPatient.route) },
                containerColor = Primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Patient", tint = Color.White)
            }
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
                query = searchQuery,
                onQueryChange = { viewModel.searchPatients(it) },
                placeholder = "Search patients by name or phone..."
            )

            Spacer(modifier = Modifier.height(16.dp))

            when (val state = patientsState) {
                is Resource.Loading -> {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(5) { LoadingShimmer(modifier = Modifier.height(80.dp)) }
                    }
                }
                is Resource.Success -> {
                    val patients = state.data ?: emptyList()
                    if (patients.isEmpty()) {
                        EmptyView(message = "No patients found")
                    } else {
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            items(patients) { patient ->
                                PatientCard(
                                    patient = patient,
                                    onClick = {
                                        navController.navigate(Screen.PatientDetail.createRoute(patient.id))
                                    }
                                )
                            }
                        }
                    }
                }
                is Resource.Error -> {
                    ErrorView(
                        message = state.message ?: "Error loading patients",
                        onRetry = { viewModel.refresh() }
                    )
                }
            }
        }
    }
}

@Composable
fun PatientCard(
    patient: Patient,
    onClick: () -> Unit
) {
    val statusColor = when (patient.status) {
        "critical" -> EmergencyRed
        "active" -> AvailableGreen
        else -> OccupiedOrange
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = patient.name.take(2).uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    color = Primary,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = patient.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${patient.age} yrs • ${patient.gender} • ${patient.bloodGroup}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondaryLight
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = patient.phone,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondaryLight
                )
            }

            // Status indicator
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(statusColor)
            )
        }
    }
}
