package com.hospital.management.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hospital.management.data.model.Patient
import com.hospital.management.data.repository.PatientRepository
import com.hospital.management.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientViewModel @Inject constructor(
    private val patientRepository: PatientRepository
) : ViewModel() {

    private val _patients = MutableStateFlow<Resource<List<Patient>>>(Resource.Loading())
    val patients: StateFlow<Resource<List<Patient>>> = _patients.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        loadPatients()
    }

    fun loadPatients() {
        viewModelScope.launch {
            patientRepository.getPatients().collect { result ->
                _patients.value = result
            }
        }
    }

    fun searchPatients(query: String) {
        _searchQuery.value = query
        viewModelScope.launch {
            if (query.isBlank()) {
                loadPatients()
            } else {
                patientRepository.searchPatients(query).collect { result ->
                    _patients.value = result
                }
            }
        }
    }

    fun refresh() {
        loadPatients()
    }
}
