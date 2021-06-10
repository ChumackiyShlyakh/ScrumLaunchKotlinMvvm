package com.omnianobis.kotlinmvvmdagger.domain.repository

import androidx.lifecycle.LiveData
import com.omnianobis.kotlinmvvmdagger.common.event.NetworkStateEvent

interface INetworkStateRepository {

    fun showNetworkConnectionError()
    fun showNetworkConnectionErrorDialog()
    fun hideNetworkConnectionError()
    fun observeNetworkConnectionState(): LiveData<NetworkStateEvent>
}