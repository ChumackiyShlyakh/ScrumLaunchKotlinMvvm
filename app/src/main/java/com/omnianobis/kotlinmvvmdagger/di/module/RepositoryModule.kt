package com.omnianobis.kotlinmvvmdagger.di.module

import com.omnianobis.kotlinmvvmdagger.data.repository.ItemsRepositoryImpl
import com.omnianobis.kotlinmvvmdagger.data.repository.NetworkStateRepositoryImpl
import com.omnianobis.kotlinmvvmdagger.data.repository.ProgressRepositoryImpl
import com.omnianobis.kotlinmvvmdagger.domain.repository.IItemsRepository
import com.omnianobis.kotlinmvvmdagger.domain.repository.INetworkStateRepository
import com.omnianobis.kotlinmvvmdagger.domain.repository.IProgressRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsItemsRepository(repository: ItemsRepositoryImpl): IItemsRepository

    @Binds
    @Singleton
    abstract fun bindsProgressRepository(repository: ProgressRepositoryImpl): IProgressRepository

    @Binds
    @Singleton
    abstract fun bindsNetworkStateRepository(repository: NetworkStateRepositoryImpl): INetworkStateRepository
}