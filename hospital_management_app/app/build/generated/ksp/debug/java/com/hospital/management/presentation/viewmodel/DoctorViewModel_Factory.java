package com.hospital.management.presentation.viewmodel;

import com.hospital.management.data.repository.DoctorRepository;
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
public final class DoctorViewModel_Factory implements Factory<DoctorViewModel> {
  private final Provider<DoctorRepository> doctorRepositoryProvider;

  public DoctorViewModel_Factory(Provider<DoctorRepository> doctorRepositoryProvider) {
    this.doctorRepositoryProvider = doctorRepositoryProvider;
  }

  @Override
  public DoctorViewModel get() {
    return newInstance(doctorRepositoryProvider.get());
  }

  public static DoctorViewModel_Factory create(
      Provider<DoctorRepository> doctorRepositoryProvider) {
    return new DoctorViewModel_Factory(doctorRepositoryProvider);
  }

  public static DoctorViewModel newInstance(DoctorRepository doctorRepository) {
    return new DoctorViewModel(doctorRepository);
  }
}
