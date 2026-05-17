package com.hospital.management.presentation.viewmodel;

import com.hospital.management.data.local.DataStoreManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public AuthViewModel_Factory(Provider<DataStoreManager> dataStoreManagerProvider) {
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(dataStoreManagerProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<DataStoreManager> dataStoreManagerProvider) {
    return new AuthViewModel_Factory(dataStoreManagerProvider);
  }

  public static AuthViewModel newInstance(DataStoreManager dataStoreManager) {
    return new AuthViewModel(dataStoreManager);
  }
}
