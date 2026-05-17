package com.hospital.management.presentation.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hospital.management.presentation.components.*
import com.hospital.management.presentation.navigation.Screen
import com.hospital.management.presentation.theme.*
import com.hospital.management.presentation.viewmodel.DashboardViewModel
import com.hospital.management.presentation.viewmodel.AuthViewModel
import com.hospital.management.util.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavHostController,
    viewModel: DashboardViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val statsState by viewModel.stats.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val userName by authViewModel.userName.collectAsState()

    Scaffold(
        bottomBar = {
            DashboardBottomNav(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(AppBackground)
                .verticalScroll(rememberScrollState())
        ) {
            // Header with Gradient
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Primary, PrimaryDark)
                        ),
                        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
                    )
                    .padding(top = 48.dp, start = 24.dp, end = 24.dp, bottom = 40.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Hello,", color = Color.White.copy(alpha = 0.8f), fontSize = 16.sp)
                            Text(
                                text = userName ?: "Hospital Admin",
                                color = Color.White,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Row {
                            IconButton(
                                onClick = { navController.navigate(Screen.Notifications.route) },
                                modifier = Modifier.clip(CircleShape).background(Color.White.copy(alpha = 0.15f))
                            ) {
                                Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.White)
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            IconButton(
                                onClick = { navController.navigate(Screen.Profile.route) },
                                modifier = Modifier.clip(CircleShape).background(Color.White.copy(alpha = 0.15f))
                            ) {
                                Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White)
                            }
                        }
                    }
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                // Stats Grid
                when (val state = statsState) {
                    is Resource.Loading -> {
                        repeat(2) {
                            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                LoadingShimmer(modifier = Modifier.weight(1f).height(100.dp))
                                LoadingShimmer(modifier = Modifier.weight(1f).height(100.dp))
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                        }
                    }
                    is Resource.Success -> {
                        val stats = state.data!!
                        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            DashboardStatCard(
                                title = "Patients",
                                value = stats.totalPatients.toString(),
                                icon = Icons.Default.People,
                                color = Primary,
                                modifier = Modifier.weight(1f)
                            )
                            DashboardStatCard(
                                title = "Doctors",
                                value = stats.totalDoctors.toString(),
                                icon = Icons.Default.LocalHospital,
                                color = Secondary,
                                modifier = Modifier.weight(1f)
                            )
                        }
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            DashboardStatCard(
                                title = "Appointments",
                                value = stats.todayAppointments.toString(),
                                icon = Icons.Default.CalendarToday,
                                color = Info,
                                modifier = Modifier.weight(1f)
                            )
                            DashboardStatCard(
                                title = "Available Beds",
                                value = stats.availableBeds.toString(),
                                icon = Icons.Default.Bed,
                                color = AvailableGreen,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                    is Resource.Error -> {
                        ErrorView(message = state.message ?: "Error loading stats", onRetry = { viewModel.refresh() })
                    }
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Quick Actions
                Text(
                    text = "Quick Actions",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPrimaryLight,
                    modifier = Modifier.padding(start = 4.dp, bottom = 16.dp)
                )

                PremiumQuickActionGrid(navController = navController)
                
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun DashboardStatCard(
    title: String,
    value: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardStrokeLight.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = value, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = TextPrimaryLight)
            Text(text = title, style = MaterialTheme.typography.labelSmall, color = TextSecondaryLight)
        }
    }
}

@Composable
fun PremiumQuickActionGrid(navController: NavHostController) {
    val actions = listOf(
        Triple("Patients", Icons.Default.People, Screen.PatientList.route),
        Triple("Doctors", Icons.Default.LocalHospital, Screen.DoctorList.route),
        Triple("Schedule", Icons.Default.CalendarMonth, Screen.AppointmentList.route),
        Triple("Scripts", Icons.Default.Medication, Screen.PrescriptionList.route),
        Triple("Pharmacy", Icons.Default.Store, Screen.MedicineList.route),
        Triple("Payments", Icons.Default.AccountBalanceWallet, Screen.Billing.route),
        Triple("Laboratory", Icons.Default.Biotech, Screen.LabTests.route),
        Triple("Emergency", Icons.Default.Emergency, Screen.EmergencySos.route),
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        val rows = actions.chunked(4)
        rows.forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { (title, icon, route) ->
                    PremiumQuickActionItem(
                        title = title,
                        icon = icon,
                        onClick = { navController.navigate(route) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun PremiumQuickActionItem(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, CardStrokeLight.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = title, tint = Primary, modifier = Modifier.size(28.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimaryLight,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}

@Composable
fun DashboardBottomNav(navController: NavHostController) {
    val items = listOf(
        Triple("Home", Icons.Default.Home, Screen.Dashboard.route),
        Triple("Patients", Icons.Default.People, Screen.PatientList.route),
        Triple("Doctors", Icons.Default.LocalHospital, Screen.DoctorList.route),
        Triple("Settings", Icons.Default.Settings, Screen.Settings.route),
    )

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        items.forEach { (label, icon, route) ->
            NavigationBarItem(
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label, fontSize = 10.sp) },
                selected = false, // You'd normally track this
                onClick = { navController.navigate(route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Primary,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Primary.copy(alpha = 0.1f)
                )
            )
        }
    }
}
