package com.omnianobis.kotlinmvvmdagger.di.module.viewmodel

import androidx.lifecycle.ViewModel
import com.omnianobis.kotlinmvvmdagger.di.mapkey.ViewModelKey
import com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.main.FirstViewModel
import com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.main.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun bindFirstViewModel(viewModel: FirstViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun bindSecondViewModel(viewModel: SecondViewModel): ViewModel
}