package com.hospital.management.presentation.screens.doctor

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
import com.hospital.management.data.model.Doctor
import com.hospital.management.presentation.components.*
import com.hospital.management.presentation.navigation.Screen
import com.hospital.management.presentation.theme.*
import com.hospital.management.presentation.viewmodel.DoctorViewModel
import com.hospital.management.util.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorListScreen(
    navController: NavHostController,
    viewModel: DoctorViewModel = hiltViewModel()
) {
    val doctorsState by viewModel.doctors.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Doctors", fontWeight = FontWeight.Bold) },
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
            when (val state = doctorsState) {
                is Resource.Loading -> {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(5) { LoadingShimmer(modifier = Modifier.height(100.dp)) }
                    }
                }
                is Resource.Success -> {
                    val doctors = state.data ?: emptyList()
                    if (doctors.isEmpty()) {
                        EmptyView(message = "No doctors found")
                    } else {
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            items(doctors) { doctor ->
                                DoctorCard(
                                    doctor = doctor,
                                    onClick = {
                                        navController.navigate(Screen.DoctorDetail.createRoute(doctor.id))
                                    }
                                )
                            }
                        }
                    }
                }
                is Resource.Error -> {
                    ErrorView(
                        message = state.message ?: "Error loading doctors",
                        onRetry = { viewModel.refresh() }
                    )
                }
            }
        }
    }
}

@Composable
fun DoctorCard(
    doctor: Doctor,
    onClick: () -> Unit
) {
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
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Secondary.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = Primary
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = doctor.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = doctor.specialization,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${doctor.experienceYears} yrs exp • ${doctor.qualification}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondaryLight
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        modifier = Modifier.size(16.dp),
                        tint = Warning
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${doctor.rating} (${doctor.totalReviews} reviews)",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondaryLight
                    )
                }
            }

            if (doctor.isAvailable) {
                Badge(containerColor = AvailableGreen) { Text("Available") }
            } else {
                Badge(containerColor = OccupiedOrange) { Text("Busy") }
            }
        }
    }
}
