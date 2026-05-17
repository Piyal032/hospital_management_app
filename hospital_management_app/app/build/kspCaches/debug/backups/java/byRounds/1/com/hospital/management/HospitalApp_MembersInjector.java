package com.hospital.management;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class HospitalApp_MembersInjector implements MembersInjector<HospitalApp> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public HospitalApp_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<HospitalApp> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new HospitalApp_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(HospitalApp instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.hospital.management.HospitalApp.workerFactory")
  public static void injectWorkerFactory(HospitalApp instance, HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
