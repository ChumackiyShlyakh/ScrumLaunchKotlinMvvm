package com.omnianobis.kotlinmvvmdagger.di

import android.app.Application
import android.content.Context
import com.omnianobis.kotlinmvvmdagger.App
import com.omnianobis.kotlinmvvmdagger.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityModule::class, DatabaseModule::class,
        NetworkModule::class, RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun context(): Context
}