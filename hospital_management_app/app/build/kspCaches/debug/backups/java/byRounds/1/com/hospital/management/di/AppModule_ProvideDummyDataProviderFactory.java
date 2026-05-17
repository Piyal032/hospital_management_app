package com.hospital.management.di;

import com.hospital.management.util.DummyDataProvider;
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
public final class AppModule_ProvideDummyDataProviderFactory implements Factory<DummyDataProvider> {
  @Override
  public DummyDataProvider get() {
    return provideDummyDataProvider();
  }

  public static AppModule_ProvideDummyDataProviderFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DummyDataProvider provideDummyDataProvider() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDummyDataProvider());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideDummyDataProviderFactory INSTANCE = new AppModule_ProvideDummyDataProviderFactory();
  }
}
