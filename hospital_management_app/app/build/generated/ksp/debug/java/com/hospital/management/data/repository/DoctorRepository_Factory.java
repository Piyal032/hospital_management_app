package com.hospital.management.data.repository;

import com.hospital.management.data.local.DoctorDao;
import com.hospital.management.data.remote.ApiService;
import com.hospital.management.util.DummyDataProvider;
import com.hospital.management.util.NetworkUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DoctorRepository_Factory implements Factory<DoctorRepository> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<DoctorDao> doctorDaoProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  private final Provider<DummyDataProvider> dummyDataProvider;

  public DoctorRepository_Factory(Provider<ApiService> apiServiceProvider,
      Provider<DoctorDao> doctorDaoProvider, Provider<NetworkUtils> networkUtilsProvider,
      Provider<DummyDataProvider> dummyDataProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.doctorDaoProvider = doctorDaoProvider;
    this.networkUtilsProvider = networkUtilsProvider;
    this.dummyDataProvider = dummyDataProvider;
  }

  @Override
  public DoctorRepository get() {
    return newInstance(apiServiceProvider.get(), doctorDaoProvider.get(), networkUtilsProvider.get(), dummyDataProvider.get());
  }

  public static DoctorRepository_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<DoctorDao> doctorDaoProvider, Provider<NetworkUtils> networkUtilsProvider,
      Provider<DummyDataProvider> dummyDataProvider) {
    return new DoctorRepository_Factory(apiServiceProvider, doctorDaoProvider, networkUtilsProvider, dummyDataProvider);
  }

  public static DoctorRepository newInstance(ApiService apiService, DoctorDao doctorDao,
      NetworkUtils networkUtils, DummyDataProvider dummyDataProvider) {
    return new DoctorRepository(apiService, doctorDao, networkUtils, dummyDataProvider);
  }
}
