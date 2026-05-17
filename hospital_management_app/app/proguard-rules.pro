# ProGuard rules
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep class com.hospital.management.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
-dontwarn com.google.android.gms.**
-keep class com.google.android.gms.** { *; }
