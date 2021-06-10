package com.omnianobis.kotlinmvvmdagger.di.module

import com.omnianobis.kotlinmvvmdagger.di.provider.MainActivityProviders
import com.omnianobis.kotlinmvvmdagger.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityProviders::class])
    abstract fun bindMainActivity(): MainActivity
}