package com.omnianobis.kotlinmvvmdagger.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.omnianobis.kotlinmvvmdagger.common.NetworkUtils
import com.omnianobis.kotlinmvvmdagger.common.event.NetworkStateEvent
import com.omnianobis.kotlinmvvmdagger.domain.repository.INetworkStateRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkStateRepositoryImpl @Inject constructor() : INetworkStateRepository {

    private val networkConnectionStateEvent: MutableLiveData<NetworkStateEvent> = MutableLiveData()

    init {
        networkConnectionStateEvent.value =
            takeIf { NetworkUtils.isOnline() }?.let { NetworkStateEvent.HIDE }
                ?: let { NetworkStateEvent.SHOW }
    }

    override fun showNetworkConnectionError() {
        CoroutineScope(Dispatchers.Main).launch {
            networkConnectionStateEvent.value = NetworkStateEvent.SHOW
        }
    }

    override fun showNetworkConnectionErrorDialog() {
        CoroutineScope(Dispatchers.Main).launch {
            takeIf { networkConnectionStateEvent.value != NetworkStateEvent.ERROR_DIALOG }?.let {
                networkConnectionStateEvent.value = NetworkStateEvent.ERROR_DIALOG
            }
        }
    }

    override fun hideNetworkConnectionError() {
        CoroutineScope(Dispatchers.Main).launch {
            networkConnectionStateEvent.value = NetworkStateEvent.HIDE
        }
    }

    override fun observeNetworkConnectionState(): LiveData<NetworkStateEvent> =
        networkConnectionStateEvent
}