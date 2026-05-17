package com.hospital.management.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hospital.management.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    val userName: StateFlow<String?> = dataStoreManager.userName
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val userEmail: StateFlow<String?> = dataStoreManager.userEmail
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val userRole: StateFlow<String?> = dataStoreManager.userRole
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val userPhone: StateFlow<String?> = dataStoreManager.userPhone
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val userDob: StateFlow<String?> = dataStoreManager.userDob
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val userBloodGroup: StateFlow<String?> = dataStoreManager.userBloodGroup
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val userAddress: StateFlow<String?> = dataStoreManager.userAddress
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun register(name: String, email: String, role: String) {
        viewModelScope.launch {
            dataStoreManager.saveUserData(
                userId = "USER_${System.currentTimeMillis()}",
                name = name,
                email = email,
                role = role
            )
        }
    }

    fun logout() {
        viewModelScope.launch {
            dataStoreManager.clearUserData()
        }
    }

    fun updateProfile(
        name: String,
        role: String,
        phone: String,
        dob: String,
        bloodGroup: String,
        address: String
    ) {
        viewModelScope.launch {
            val email = dataStoreManager.userEmail.first() ?: ""
            dataStoreManager.saveUserData(
                userId = "USER_${System.currentTimeMillis()}",
                name = name,
                email = email,
                role = role,
                phone = phone,
                dob = dob,
                bloodGroup = bloodGroup,
                address = address
            )
        }
    }
}
