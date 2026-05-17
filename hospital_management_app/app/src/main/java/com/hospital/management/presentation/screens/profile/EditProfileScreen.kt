package com.hospital.management.presentation.screens.profile

import androidx.compose.foundation.background
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hospital.management.presentation.theme.Primary
import com.hospital.management.presentation.theme.AppBackground
import com.hospital.management.presentation.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    navController: NavHostController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    val currentName by viewModel.userName.collectAsState()
    val currentRole by viewModel.userRole.collectAsState()
    val currentPhone by viewModel.userPhone.collectAsState()
    val currentDob by viewModel.userDob.collectAsState()
    val currentBloodGroup by viewModel.userBloodGroup.collectAsState()
    val currentAddress by viewModel.userAddress.collectAsState()

    var name by remember { mutableStateOf(currentName ?: "") }
    var selectedRole by remember { mutableStateOf(currentRole ?: "Patient") }
    var phone by remember { mutableStateOf(currentPhone ?: "") }
    var dob by remember { mutableStateOf(currentDob ?: "") }
    var bloodGroup by remember { mutableStateOf(currentBloodGroup ?: "") }
    var address by remember { mutableStateOf(currentAddress ?: "") }
    
    var isRoleExpanded by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val roles = listOf("Patient", "Doctor", "Staff")

    // Update initial values when data is loaded
    LaunchedEffect(currentName, currentRole, currentPhone, currentDob, currentBloodGroup, currentAddress) {
        if (name.isEmpty()) name = currentName ?: ""
        if (selectedRole == "Patient") selectedRole = currentRole ?: "Patient"
        if (phone.isEmpty()) phone = currentPhone ?: ""
        if (dob.isEmpty()) dob = currentDob ?: ""
        if (bloodGroup.isEmpty()) bloodGroup = currentBloodGroup ?: ""
        if (address.isEmpty()) address = currentAddress ?: ""
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profile", fontWeight = FontWeight.Bold) },
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
                .background(AppBackground)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Full Name
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Role Selection
            ExposedDropdownMenuBox(
                expanded = isRoleExpanded,
                onExpandedChange = { isRoleExpanded = !isRoleExpanded },
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = selectedRole,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("User Role") },
                    leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isRoleExpanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
                ExposedDropdownMenu(
                    expanded = isRoleExpanded,
                    onDismissRequest = { isRoleExpanded = false }
                ) {
                    roles.forEach { role ->
                        DropdownMenuItem(
                            text = { Text(role) },
                            onClick = {
                                selectedRole = role
                                isRoleExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Phone
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // DOB
            OutlinedTextField(
                value = dob,
                onValueChange = { dob = it },
                label = { Text("Date of Birth (e.g., Jan 15, 1990)") },
                leadingIcon = { Icon(Icons.Default.Cake, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Blood Group
            OutlinedTextField(
                value = bloodGroup,
                onValueChange = { bloodGroup = it },
                label = { Text("Blood Group (e.g., O+)") },
                leadingIcon = { Icon(Icons.Default.Bloodtype, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Address
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Address") },
                leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                minLines = 2
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    isLoading = true
                    viewModel.updateProfile(name, selectedRole, phone, dob, bloodGroup, address)
                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                enabled = !isLoading && name.isNotBlank()
            ) {
                if (isLoading) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
                } else {
                    Text("Save Changes", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
