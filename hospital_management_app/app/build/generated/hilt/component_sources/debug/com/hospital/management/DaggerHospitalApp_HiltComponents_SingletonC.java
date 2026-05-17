package com.hospital.management;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.hilt.work.WorkerFactoryModule_ProvideFactoryFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.work.ListenableWorker;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.hospital.management.data.local.DataStoreManager;
import com.hospital.management.data.local.DoctorDao;
import com.hospital.management.data.local.HospitalDatabase;
import com.hospital.management.data.local.PatientDao;
import com.hospital.management.data.remote.ApiService;
import com.hospital.management.data.remote.RetrofitClient;
import com.hospital.management.data.repository.DoctorRepository;
import com.hospital.management.data.repository.PatientRepository;
import com.hospital.management.di.AppModule_ProvideApiServiceFactory;
import com.hospital.management.di.AppModule_ProvideDoctorDaoFactory;
import com.hospital.management.di.AppModule_ProvideDummyDataProviderFactory;
import com.hospital.management.di.AppModule_ProvideHospitalDatabaseFactory;
import com.hospital.management.di.AppModule_ProvideNetworkUtilsFactory;
import com.hospital.management.di.AppModule_ProvidePatientDaoFactory;
import com.hospital.management.di.AppModule_ProvideRetrofitClientFactory;
import com.hospital.management.presentation.viewmodel.AuthViewModel;
import com.hospital.management.presentation.viewmodel.AuthViewModel_HiltModules;
import com.hospital.management.presentation.viewmodel.DashboardViewModel;
import com.hospital.management.presentation.viewmodel.DashboardViewModel_HiltModules;
import com.hospital.management.presentation.viewmodel.DoctorViewModel;
import com.hospital.management.presentation.viewmodel.DoctorViewModel_HiltModules;
import com.hospital.management.presentation.viewmodel.PatientViewModel;
import com.hospital.management.presentation.viewmodel.PatientViewModel_HiltModules;
import com.hospital.management.presentation.viewmodel.SplashViewModel;
import com.hospital.management.presentation.viewmodel.SplashViewModel_HiltModules;
import com.hospital.management.util.DummyDataProvider;
import com.hospital.management.util.NetworkUtils;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerHospitalApp_HiltComponents_SingletonC {
  private DaggerHospitalApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public HospitalApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements HospitalApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public HospitalApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements HospitalApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public HospitalApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements HospitalApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public HospitalApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements HospitalApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public HospitalApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements HospitalApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public HospitalApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements HospitalApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public HospitalApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements HospitalApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public HospitalApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends HospitalApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends HospitalApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends HospitalApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends HospitalApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>of(LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_AuthViewModel, AuthViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_DashboardViewModel, DashboardViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_DoctorViewModel, DoctorViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_PatientViewModel, PatientViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_SplashViewModel, SplashViewModel_HiltModules.KeyModule.provide()));
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_hospital_management_presentation_viewmodel_DoctorViewModel = "com.hospital.management.presentation.viewmodel.DoctorViewModel";

      static String com_hospital_management_presentation_viewmodel_DashboardViewModel = "com.hospital.management.presentation.viewmodel.DashboardViewModel";

      static String com_hospital_management_presentation_viewmodel_AuthViewModel = "com.hospital.management.presentation.viewmodel.AuthViewModel";

      static String com_hospital_management_presentation_viewmodel_SplashViewModel = "com.hospital.management.presentation.viewmodel.SplashViewModel";

      static String com_hospital_management_presentation_viewmodel_PatientViewModel = "com.hospital.management.presentation.viewmodel.PatientViewModel";

      @KeepFieldType
      DoctorViewModel com_hospital_management_presentation_viewmodel_DoctorViewModel2;

      @KeepFieldType
      DashboardViewModel com_hospital_management_presentation_viewmodel_DashboardViewModel2;

      @KeepFieldType
      AuthViewModel com_hospital_management_presentation_viewmodel_AuthViewModel2;

      @KeepFieldType
      SplashViewModel com_hospital_management_presentation_viewmodel_SplashViewModel2;

      @KeepFieldType
      PatientViewModel com_hospital_management_presentation_viewmodel_PatientViewModel2;
    }
  }

  private static final class ViewModelCImpl extends HospitalApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<DoctorViewModel> doctorViewModelProvider;

    private Provider<PatientViewModel> patientViewModelProvider;

    private Provider<SplashViewModel> splashViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.doctorViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.patientViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.splashViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>of(LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_AuthViewModel, ((Provider) authViewModelProvider), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_DashboardViewModel, ((Provider) dashboardViewModelProvider), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_DoctorViewModel, ((Provider) doctorViewModelProvider), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_PatientViewModel, ((Provider) patientViewModelProvider), LazyClassKeyProvider.com_hospital_management_presentation_viewmodel_SplashViewModel, ((Provider) splashViewModelProvider)));
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_hospital_management_presentation_viewmodel_AuthViewModel = "com.hospital.management.presentation.viewmodel.AuthViewModel";

      static String com_hospital_management_presentation_viewmodel_SplashViewModel = "com.hospital.management.presentation.viewmodel.SplashViewModel";

      static String com_hospital_management_presentation_viewmodel_DashboardViewModel = "com.hospital.management.presentation.viewmodel.DashboardViewModel";

      static String com_hospital_management_presentation_viewmodel_DoctorViewModel = "com.hospital.management.presentation.viewmodel.DoctorViewModel";

      static String com_hospital_management_presentation_viewmodel_PatientViewModel = "com.hospital.management.presentation.viewmodel.PatientViewModel";

      @KeepFieldType
      AuthViewModel com_hospital_management_presentation_viewmodel_AuthViewModel2;

      @KeepFieldType
      SplashViewModel com_hospital_management_presentation_viewmodel_SplashViewModel2;

      @KeepFieldType
      DashboardViewModel com_hospital_management_presentation_viewmodel_DashboardViewModel2;

      @KeepFieldType
      DoctorViewModel com_hospital_management_presentation_viewmodel_DoctorViewModel2;

      @KeepFieldType
      PatientViewModel com_hospital_management_presentation_viewmodel_PatientViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.hospital.management.presentation.viewmodel.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.dataStoreManagerProvider.get());

          case 1: // com.hospital.management.presentation.viewmodel.DashboardViewModel 
          return (T) new DashboardViewModel(singletonCImpl.provideDummyDataProvider.get());

          case 2: // com.hospital.management.presentation.viewmodel.DoctorViewModel 
          return (T) new DoctorViewModel(singletonCImpl.doctorRepositoryProvider.get());

          case 3: // com.hospital.management.presentation.viewmodel.PatientViewModel 
          return (T) new PatientViewModel(singletonCImpl.patientRepositoryProvider.get());

          case 4: // com.hospital.management.presentation.viewmodel.SplashViewModel 
          return (T) new SplashViewModel(singletonCImpl.dataStoreManagerProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends HospitalApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends HospitalApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends HospitalApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<DataStoreManager> dataStoreManagerProvider;

    private Provider<DummyDataProvider> provideDummyDataProvider;

    private Provider<RetrofitClient> provideRetrofitClientProvider;

    private Provider<ApiService> provideApiServiceProvider;

    private Provider<HospitalDatabase> provideHospitalDatabaseProvider;

    private Provider<DoctorDao> provideDoctorDaoProvider;

    private Provider<NetworkUtils> provideNetworkUtilsProvider;

    private Provider<DoctorRepository> doctorRepositoryProvider;

    private Provider<PatientDao> providePatientDaoProvider;

    private Provider<PatientRepository> patientRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private HiltWorkerFactory hiltWorkerFactory() {
      return WorkerFactoryModule_ProvideFactoryFactory.provideFactory(ImmutableMap.<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>>of());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.dataStoreManagerProvider = DoubleCheck.provider(new SwitchingProvider<DataStoreManager>(singletonCImpl, 0));
      this.provideDummyDataProvider = DoubleCheck.provider(new SwitchingProvider<DummyDataProvider>(singletonCImpl, 1));
      this.provideRetrofitClientProvider = DoubleCheck.provider(new SwitchingProvider<RetrofitClient>(singletonCImpl, 4));
      this.provideApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<ApiService>(singletonCImpl, 3));
      this.provideHospitalDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<HospitalDatabase>(singletonCImpl, 6));
      this.provideDoctorDaoProvider = DoubleCheck.provider(new SwitchingProvider<DoctorDao>(singletonCImpl, 5));
      this.provideNetworkUtilsProvider = DoubleCheck.provider(new SwitchingProvider<NetworkUtils>(singletonCImpl, 7));
      this.doctorRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<DoctorRepository>(singletonCImpl, 2));
      this.providePatientDaoProvider = DoubleCheck.provider(new SwitchingProvider<PatientDao>(singletonCImpl, 9));
      this.patientRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<PatientRepository>(singletonCImpl, 8));
    }

    @Override
    public void injectHospitalApp(HospitalApp hospitalApp) {
      injectHospitalApp2(hospitalApp);
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @CanIgnoreReturnValue
    private HospitalApp injectHospitalApp2(HospitalApp instance) {
      HospitalApp_MembersInjector.injectWorkerFactory(instance, hiltWorkerFactory());
      return instance;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.hospital.management.data.local.DataStoreManager 
          return (T) new DataStoreManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.hospital.management.util.DummyDataProvider 
          return (T) AppModule_ProvideDummyDataProviderFactory.provideDummyDataProvider();

          case 2: // com.hospital.management.data.repository.DoctorRepository 
          return (T) new DoctorRepository(singletonCImpl.provideApiServiceProvider.get(), singletonCImpl.provideDoctorDaoProvider.get(), singletonCImpl.provideNetworkUtilsProvider.get(), singletonCImpl.provideDummyDataProvider.get());

          case 3: // com.hospital.management.data.remote.ApiService 
          return (T) AppModule_ProvideApiServiceFactory.provideApiService(singletonCImpl.provideRetrofitClientProvider.get());

          case 4: // com.hospital.management.data.remote.RetrofitClient 
          return (T) AppModule_ProvideRetrofitClientFactory.provideRetrofitClient();

          case 5: // com.hospital.management.data.local.DoctorDao 
          return (T) AppModule_ProvideDoctorDaoFactory.provideDoctorDao(singletonCImpl.provideHospitalDatabaseProvider.get());

          case 6: // com.hospital.management.data.local.HospitalDatabase 
          return (T) AppModule_ProvideHospitalDatabaseFactory.provideHospitalDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 7: // com.hospital.management.util.NetworkUtils 
          return (T) AppModule_ProvideNetworkUtilsFactory.provideNetworkUtils(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 8: // com.hospital.management.data.repository.PatientRepository 
          return (T) new PatientRepository(singletonCImpl.provideApiServiceProvider.get(), singletonCImpl.providePatientDaoProvider.get(), singletonCImpl.provideNetworkUtilsProvider.get(), singletonCImpl.provideDummyDataProvider.get());

          case 9: // com.hospital.management.data.local.PatientDao 
          return (T) AppModule_ProvidePatientDaoFactory.providePatientDao(singletonCImpl.provideHospitalDatabaseProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
