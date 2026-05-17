package com.hospital.management.presentation.viewmodel;

import com.hospital.management.util.DummyDataProvider;
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<DummyDataProvider> dummyDataProvider;

  public DashboardViewModel_Factory(Provider<DummyDataProvider> dummyDataProvider) {
    this.dummyDataProvider = dummyDataProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(dummyDataProvider.get());
  }

  public static DashboardViewModel_Factory create(Provider<DummyDataProvider> dummyDataProvider) {
    return new DashboardViewModel_Factory(dummyDataProvider);
  }

  public static DashboardViewModel newInstance(DummyDataProvider dummyDataProvider) {
    return new DashboardViewModel(dummyDataProvider);
  }
}
