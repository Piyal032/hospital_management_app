package com.hospital.management.util

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val isFromCache: Boolean = false
) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T, isFromCache: Boolean = false) : Resource<T>(data = data, isFromCache = isFromCache)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
}
