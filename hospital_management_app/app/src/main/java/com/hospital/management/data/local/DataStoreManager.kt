package com.hospital.management.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "hospital_prefs")

@Singleton
class DataStoreManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        val AUTH_TOKEN = stringPreferencesKey("auth_token")
        val USER_ID = stringPreferencesKey("user_id")
        val USER_NAME = stringPreferencesKey("user_name")
        val USER_EMAIL = stringPreferencesKey("user_email")
        val USER_ROLE = stringPreferencesKey("user_role")
        val USER_PHONE = stringPreferencesKey("user_phone")
        val USER_DOB = stringPreferencesKey("user_dob")
        val USER_BLOOD_GROUP = stringPreferencesKey("user_blood_group")
        val USER_ADDRESS = stringPreferencesKey("user_address")
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")
        val LANGUAGE = stringPreferencesKey("language")
        val NOTIFICATIONS_ENABLED = booleanPreferencesKey("notifications_enabled")
        val BIOMETRIC_ENABLED = booleanPreferencesKey("biometric_enabled")
        val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")
    }

    val authToken: Flow<String?> = context.dataStore.data.map { it[AUTH_TOKEN] }
    val isLoggedIn: Flow<Boolean> = context.dataStore.data.map { it[IS_LOGGED_IN] ?: false }
    val isDarkMode: Flow<Boolean> = context.dataStore.data.map { it[IS_DARK_MODE] ?: false }
    val userName: Flow<String?> = context.dataStore.data.map { it[USER_NAME] }
    val userEmail: Flow<String?> = context.dataStore.data.map { it[USER_EMAIL] }
    val userRole: Flow<String?> = context.dataStore.data.map { it[USER_ROLE] }
    val userPhone: Flow<String?> = context.dataStore.data.map { it[USER_PHONE] }
    val userDob: Flow<String?> = context.dataStore.data.map { it[USER_DOB] }
    val userBloodGroup: Flow<String?> = context.dataStore.data.map { it[USER_BLOOD_GROUP] }
    val userAddress: Flow<String?> = context.dataStore.data.map { it[USER_ADDRESS] }
    val onboardingCompleted: Flow<Boolean> = context.dataStore.data.map { it[ONBOARDING_COMPLETED] ?: false }

    suspend fun saveAuthToken(token: String) {
        context.dataStore.edit { it[AUTH_TOKEN] = token }
    }

    suspend fun saveUserData(
        userId: String,
        name: String,
        email: String,
        role: String,
        phone: String = "",
        dob: String = "",
        bloodGroup: String = "",
        address: String = ""
    ) {
        context.dataStore.edit {
            it[USER_ID] = userId
            it[USER_NAME] = name
            it[USER_EMAIL] = email
            it[USER_ROLE] = role
            it[USER_PHONE] = phone
            it[USER_DOB] = dob
            it[USER_BLOOD_GROUP] = bloodGroup
            it[USER_ADDRESS] = address
            it[IS_LOGGED_IN] = true
        }
    }

    suspend fun setLoggedIn(loggedIn: Boolean) {
        context.dataStore.edit { it[IS_LOGGED_IN] = loggedIn }
    }

    suspend fun setDarkMode(darkMode: Boolean) {
        context.dataStore.edit { it[IS_DARK_MODE] = darkMode }
    }

    suspend fun setLanguage(language: String) {
        context.dataStore.edit { it[LANGUAGE] = language }
    }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { it[ONBOARDING_COMPLETED] = completed }
    }

    suspend fun clearUserData() {
        context.dataStore.edit {
            it.remove(AUTH_TOKEN)
            it.remove(USER_ID)
            it.remove(USER_NAME)
            it.remove(USER_EMAIL)
            it.remove(USER_ROLE)
            it.remove(USER_PHONE)
            it.remove(USER_DOB)
            it.remove(USER_BLOOD_GROUP)
            it.remove(USER_ADDRESS)
            it[IS_LOGGED_IN] = false
        }
    }
}
