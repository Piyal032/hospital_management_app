package com.hospital.management.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hospital.management.util.DashboardStats
import com.hospital.management.util.DummyDataProvider
import com.hospital.management.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dummyDataProvider: DummyDataProvider
) : ViewModel() {

    private val _stats = MutableStateFlow<Resource<DashboardStats>>(Resource.Loading())
    val stats: StateFlow<Resource<DashboardStats>> = _stats.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    init {
        loadStats()
    }

    fun loadStats() {
        viewModelScope.launch {
            _stats.value = Resource.Loading()
            // Simulate API call
            kotlinx.coroutines.delay(500)
            _stats.value = Resource.Success(dummyDataProvider.getDummyDashboardStats())
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.value = true
            loadStats()
            _isRefreshing.value = false
        }
    }
}
