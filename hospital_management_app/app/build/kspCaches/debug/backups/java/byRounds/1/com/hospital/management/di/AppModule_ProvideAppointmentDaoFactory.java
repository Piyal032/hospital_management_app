package com.hospital.management.di;

import com.hospital.management.data.local.AppointmentDao;
import com.hospital.management.data.local.HospitalDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AppModule_ProvideAppointmentDaoFactory implements Factory<AppointmentDao> {
  private final Provider<HospitalDatabase> databaseProvider;

  public AppModule_ProvideAppointmentDaoFactory(Provider<HospitalDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public AppointmentDao get() {
    return provideAppointmentDao(databaseProvider.get());
  }

  public static AppModule_ProvideAppointmentDaoFactory create(
      Provider<HospitalDatabase> databaseProvider) {
    return new AppModule_ProvideAppointmentDaoFactory(databaseProvider);
  }

  public static AppointmentDao provideAppointmentDao(HospitalDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAppointmentDao(database));
  }
}
