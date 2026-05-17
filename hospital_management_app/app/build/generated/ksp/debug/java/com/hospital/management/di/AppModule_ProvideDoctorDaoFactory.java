package com.hospital.management.di;

import com.hospital.management.data.local.DoctorDao;
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
public final class AppModule_ProvideDoctorDaoFactory implements Factory<DoctorDao> {
  private final Provider<HospitalDatabase> databaseProvider;

  public AppModule_ProvideDoctorDaoFactory(Provider<HospitalDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public DoctorDao get() {
    return provideDoctorDao(databaseProvider.get());
  }

  public static AppModule_ProvideDoctorDaoFactory create(
      Provider<HospitalDatabase> databaseProvider) {
    return new AppModule_ProvideDoctorDaoFactory(databaseProvider);
  }

  public static DoctorDao provideDoctorDao(HospitalDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDoctorDao(database));
  }
}
