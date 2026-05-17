# Hospital Management Android App

A production-level Hospital Management Android Application built using Kotlin and Jetpack Compose following MVVM + Clean Architecture principles.

## Features
- Patient Management
- Doctor Management
- Appointment Booking
- Prescription System
- Medicine Management
- Billing & Payments
- Emergency SOS
- Ambulance Tracking UI
- Bed Availability Tracking
- Reports & Analytics Dashboard
- Firebase Authentication
- Push Notifications
- Offline Support
- Dark/Light Theme
- Search & Filter
- Chat Support UI
- Video Consultation UI

## Tech Stack
- Kotlin
- Jetpack Compose
- MVVM Architecture
- Clean Architecture
- Hilt Dependency Injection
- Retrofit
- OkHttp
- Coroutines + Flow
- Room Database
- DataStore
- Firebase Authentication
- Firebase Cloud Messaging
- Navigation Compose
- Material 3
- WorkManager
- Coil

## Architecture
The application follows a scalable layered architecture:

Presentation Layer → ViewModel → UseCases → Repository → API / Room DB / Local JSON

## Offline Support
Implemented repository fallback mechanism:

1. API
2. Room Database Cache
3. Local Dummy JSON Data

This ensures the app continues working even if the API fails.

## Key Highlights
- Modern Compose UI
- Reusable Components
- Offline-first Approach
- Secure Session Management
- Clean Folder Structure
- Smooth Animations
- Production-ready Architecture
- Android 10–15 Support

## Future Improvements
- AI Chat Assistant
- Google Maps Integration
- Face Authentication
- Wear OS Support
- PDF Prescription Export
- QR Appointment Scanner

## Author
Piyal Goswami
