package com.hospital.management.presentation.screens.appointment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hospital.management.presentation.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentBookingScreen(
    navController: NavHostController
) {
    var patientName by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("Cardiology") }
    var doctor by remember { mutableStateOf("Dr. Rajesh Verma") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    
    var isDeptExpanded by remember { mutableStateOf(false) }
    var isDocExpanded by remember { mutableStateOf(false) }
    
    val departments = listOf("Cardiology", "Neurology", "Orthopedics", "Gynecology", "Pediatrics")
    val doctors = listOf("Dr. Rajesh Verma", "Dr. Priya Nair", "Dr. Amit Khanna", "Dr. Sunita Reddy")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book Appointment", fontWeight = FontWeight.Bold) },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = patientName,
                onValueChange = { patientName = it },
                label = { Text("Patient Name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = isDeptExpanded,
                onExpandedChange = { isDeptExpanded = !isDeptExpanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = department,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Department") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDeptExpanded) },
                    modifier = Modifier.menuAnchor().fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                ExposedDropdownMenu(
                    expanded = isDeptExpanded,
                    onDismissRequest = { isDeptExpanded = false }
                ) {
                    departments.forEach { dept ->
                        DropdownMenuItem(
                            text = { Text(dept) },
                            onClick = {
                                department = dept
                                isDeptExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = isDocExpanded,
                onExpandedChange = { isDocExpanded = !isDocExpanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = doctor,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Doctor") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDocExpanded) },
                    modifier = Modifier.menuAnchor().fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                ExposedDropdownMenu(
                    expanded = isDocExpanded,
                    onDismissRequest = { isDocExpanded = false }
                ) {
                    doctors.forEach { doc ->
                        DropdownMenuItem(
                            text = { Text(doc) },
                            onClick = {
                                doctor = doc
                                isDocExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text("Date (YYYY-MM-DD)") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                trailingIcon = { Icon(Icons.Default.CalendarToday, contentDescription = null) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                label = { Text("Time (e.g. 10:30 AM)") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                trailingIcon = { Icon(Icons.Default.Schedule, contentDescription = null) }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                enabled = patientName.isNotBlank() && date.isNotBlank() && time.isNotBlank()
            ) {
                Text("Confirm Booking", fontWeight = FontWeight.Bold)
            }
        }
    }
}
