package com.hospital.management.di;

import com.hospital.management.data.local.HospitalDatabase;
import com.hospital.management.data.local.MedicineDao;
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
public final class AppModule_ProvideMedicineDaoFactory implements Factory<MedicineDao> {
  private final Provider<HospitalDatabase> databaseProvider;

  public AppModule_ProvideMedicineDaoFactory(Provider<HospitalDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MedicineDao get() {
    return provideMedicineDao(databaseProvider.get());
  }

  public static AppModule_ProvideMedicineDaoFactory create(
      Provider<HospitalDatabase> databaseProvider) {
    return new AppModule_ProvideMedicineDaoFactory(databaseProvider);
  }

  public static MedicineDao provideMedicineDao(HospitalDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMedicineDao(database));
  }
}
