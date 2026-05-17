package com.hospital.management.data.remote;

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
public final class RetrofitClient_Factory implements Factory<RetrofitClient> {
  @Override
  public RetrofitClient get() {
    return newInstance();
  }

  public static RetrofitClient_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RetrofitClient newInstance() {
    return new RetrofitClient();
  }

  private static final class InstanceHolder {
    private static final RetrofitClient_Factory INSTANCE = new RetrofitClient_Factory();
  }
}
