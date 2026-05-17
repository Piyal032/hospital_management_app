package com.hospital.management.di;

import com.hospital.management.data.remote.RetrofitClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideRetrofitClientFactory implements Factory<RetrofitClient> {
  @Override
  public RetrofitClient get() {
    return provideRetrofitClient();
  }

  public static AppModule_ProvideRetrofitClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RetrofitClient provideRetrofitClient() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideRetrofitClient());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideRetrofitClientFactory INSTANCE = new AppModule_ProvideRetrofitClientFactory();
  }
}
