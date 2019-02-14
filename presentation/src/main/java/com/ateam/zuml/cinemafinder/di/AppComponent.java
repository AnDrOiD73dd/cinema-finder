package com.ateam.zuml.cinemafinder.di;

import android.content.Context;

import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.di.builder.ActivityBuilder;
import com.ateam.zuml.cinemafinder.di.modules.DataModule;
import com.ateam.zuml.cinemafinder.di.modules.DatabaseModule;
import com.ateam.zuml.cinemafinder.di.modules.ImageLoaderModule;
import com.ateam.zuml.cinemafinder.di.modules.MapperModule;
import com.ateam.zuml.cinemafinder.di.modules.NavigationModule;
import com.ateam.zuml.cinemafinder.di.modules.ResourceModule;
import com.ateam.zuml.cinemafinder.di.modules.SchedulersModule;
import com.ateam.zuml.cinemafinder.di.modules.ServiceModule;
import com.ateam.zuml.cinemafinder.di.modules.UtilsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        DataModule.class,
        MapperModule.class,
        NavigationModule.class,
        ServiceModule.class,
        ImageLoaderModule.class,
        UtilsModule.class,
        SchedulersModule.class,
        DatabaseModule.class,
        ResourceModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder with(final Context context);
    }

    void inject(App app);
}
