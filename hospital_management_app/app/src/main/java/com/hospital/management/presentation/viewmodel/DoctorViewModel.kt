package com.hospital.management.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hospital.management.data.model.Doctor
import com.hospital.management.data.repository.DoctorRepository
import com.hospital.management.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoctorViewModel @Inject constructor(
    private val doctorRepository: DoctorRepository
) : ViewModel() {

    private val _doctors = MutableStateFlow<Resource<List<Doctor>>>(Resource.Loading())
    val doctors: StateFlow<Resource<List<Doctor>>> = _doctors.asStateFlow()

    init {
        loadDoctors()
    }

    fun loadDoctors() {
        viewModelScope.launch {
            doctorRepository.getDoctors().collect { result ->
                _doctors.value = result
            }
        }
    }

    fun getDoctorsBySpecialization(specialization: String) {
        viewModelScope.launch {
            doctorRepository.getDoctorsBySpecialization(specialization).collect { result ->
                _doctors.value = result
            }
        }
    }

    fun refresh() {
        loadDoctors()
    }
}
