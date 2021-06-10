package com.omnianobis.kotlinmvvmdagger.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.omnianobis.kotlinmvvmdagger.di.mapkey.ViewModelKey
import com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}