package com.hospital.management.util;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DummyDataProvider_Factory implements Factory<DummyDataProvider> {
  @Override
  public DummyDataProvider get() {
    return newInstance();
  }

  public static DummyDataProvider_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DummyDataProvider newInstance() {
    return new DummyDataProvider();
  }

  private static final class InstanceHolder {
    private static final DummyDataProvider_Factory INSTANCE = new DummyDataProvider_Factory();
  }
}
