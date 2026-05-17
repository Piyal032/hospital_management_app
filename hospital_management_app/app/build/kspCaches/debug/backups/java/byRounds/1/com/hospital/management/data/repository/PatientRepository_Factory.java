package com.hospital.management.data.repository;

import com.hospital.management.data.local.PatientDao;
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
public final class PatientRepository_Factory implements Factory<PatientRepository> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<PatientDao> patientDaoProvider;

  private final Provider<NetworkUtils> networkUtilsProvider;

  private final Provider<DummyDataProvider> dummyDataProvider;

  public PatientRepository_Factory(Provider<ApiService> apiServiceProvider,
      Provider<PatientDao> patientDaoProvider, Provider<NetworkUtils> networkUtilsProvider,
      Provider<DummyDataProvider> dummyDataProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.patientDaoProvider = patientDaoProvider;
    this.networkUtilsProvider = networkUtilsProvider;
    this.dummyDataProvider = dummyDataProvider;
  }

  @Override
  public PatientRepository get() {
    return newInstance(apiServiceProvider.get(), patientDaoProvider.get(), networkUtilsProvider.get(), dummyDataProvider.get());
  }

  public static PatientRepository_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<PatientDao> patientDaoProvider, Provider<NetworkUtils> networkUtilsProvider,
      Provider<DummyDataProvider> dummyDataProvider) {
    return new PatientRepository_Factory(apiServiceProvider, patientDaoProvider, networkUtilsProvider, dummyDataProvider);
  }

  public static PatientRepository newInstance(ApiService apiService, PatientDao patientDao,
      NetworkUtils networkUtils, DummyDataProvider dummyDataProvider) {
    return new PatientRepository(apiService, patientDao, networkUtils, dummyDataProvider);
  }
}
