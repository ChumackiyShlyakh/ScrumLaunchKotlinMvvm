package com.omnianobis.kotlinmvvmdagger.di.module.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.omnianobis.kotlinmvvmdagger.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityViewModelModule::class, FragmentViewModelModule::class])
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}