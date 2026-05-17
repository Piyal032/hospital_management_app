package com.hospital.management.di;

import com.hospital.management.data.remote.ApiService;
import com.hospital.management.data.remote.RetrofitClient;
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
public final class AppModule_ProvideApiServiceFactory implements Factory<ApiService> {
  private final Provider<RetrofitClient> retrofitClientProvider;

  public AppModule_ProvideApiServiceFactory(Provider<RetrofitClient> retrofitClientProvider) {
    this.retrofitClientProvider = retrofitClientProvider;
  }

  @Override
  public ApiService get() {
    return provideApiService(retrofitClientProvider.get());
  }

  public static AppModule_ProvideApiServiceFactory create(
      Provider<RetrofitClient> retrofitClientProvider) {
    return new AppModule_ProvideApiServiceFactory(retrofitClientProvider);
  }

  public static ApiService provideApiService(RetrofitClient retrofitClient) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideApiService(retrofitClient));
  }
}
