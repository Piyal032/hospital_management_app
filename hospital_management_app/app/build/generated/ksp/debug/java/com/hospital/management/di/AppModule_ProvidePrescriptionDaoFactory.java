package com.hospital.management.di;

import com.hospital.management.data.local.HospitalDatabase;
import com.hospital.management.data.local.PrescriptionDao;
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
public final class AppModule_ProvidePrescriptionDaoFactory implements Factory<PrescriptionDao> {
  private final Provider<HospitalDatabase> databaseProvider;

  public AppModule_ProvidePrescriptionDaoFactory(Provider<HospitalDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PrescriptionDao get() {
    return providePrescriptionDao(databaseProvider.get());
  }

  public static AppModule_ProvidePrescriptionDaoFactory create(
      Provider<HospitalDatabase> databaseProvider) {
    return new AppModule_ProvidePrescriptionDaoFactory(databaseProvider);
  }

  public static PrescriptionDao providePrescriptionDao(HospitalDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePrescriptionDao(database));
  }
}
