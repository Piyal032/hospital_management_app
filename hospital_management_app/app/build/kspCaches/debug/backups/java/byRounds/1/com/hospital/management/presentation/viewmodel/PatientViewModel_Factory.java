package com.hospital.management.presentation.viewmodel;

import com.hospital.management.data.repository.PatientRepository;
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
public final class PatientViewModel_Factory implements Factory<PatientViewModel> {
  private final Provider<PatientRepository> patientRepositoryProvider;

  public PatientViewModel_Factory(Provider<PatientRepository> patientRepositoryProvider) {
    this.patientRepositoryProvider = patientRepositoryProvider;
  }

  @Override
  public PatientViewModel get() {
    return newInstance(patientRepositoryProvider.get());
  }

  public static PatientViewModel_Factory create(
      Provider<PatientRepository> patientRepositoryProvider) {
    return new PatientViewModel_Factory(patientRepositoryProvider);
  }

  public static PatientViewModel newInstance(PatientRepository patientRepository) {
    return new PatientViewModel(patientRepository);
  }
}
