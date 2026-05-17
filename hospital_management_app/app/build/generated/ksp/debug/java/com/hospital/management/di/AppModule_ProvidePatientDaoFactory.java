package com.hospital.management.di;

import com.hospital.management.data.local.HospitalDatabase;
import com.hospital.management.data.local.PatientDao;
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
public final class AppModule_ProvidePatientDaoFactory implements Factory<PatientDao> {
  private final Provider<HospitalDatabase> databaseProvider;

  public AppModule_ProvidePatientDaoFactory(Provider<HospitalDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PatientDao get() {
    return providePatientDao(databaseProvider.get());
  }

  public static AppModule_ProvidePatientDaoFactory create(
      Provider<HospitalDatabase> databaseProvider) {
    return new AppModule_ProvidePatientDaoFactory(databaseProvider);
  }

  public static PatientDao providePatientDao(HospitalDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePatientDao(database));
  }
}
