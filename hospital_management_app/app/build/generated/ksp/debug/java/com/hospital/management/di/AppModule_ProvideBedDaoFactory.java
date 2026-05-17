package com.hospital.management.di;

import com.hospital.management.data.local.BedDao;
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
public final class AppModule_ProvideBedDaoFactory implements Factory<BedDao> {
  private final Provider<HospitalDatabase> databaseProvider;

  public AppModule_ProvideBedDaoFactory(Provider<HospitalDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public BedDao get() {
    return provideBedDao(databaseProvider.get());
  }

  public static AppModule_ProvideBedDaoFactory create(Provider<HospitalDatabase> databaseProvider) {
    return new AppModule_ProvideBedDaoFactory(databaseProvider);
  }

  public static BedDao provideBedDao(HospitalDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBedDao(database));
  }
}
