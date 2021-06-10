package com.omnianobis.kotlinmvvmdagger.data.network

import android.content.Context
import android.content.Intent
import com.omnianobis.kotlinmvvmdagger.common.BaseBroadcastReceiver
import com.omnianobis.kotlinmvvmdagger.common.NetworkUtils
import com.omnianobis.kotlinmvvmdagger.domain.repository.INetworkStateRepository
import javax.inject.Inject

class NetworkChangeBroadcastReceiver : BaseBroadcastReceiver() {

    @Inject
    lateinit var networkStateRepository: INetworkStateRepository

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        takeIf { NetworkUtils.isOnline() }?.let {
            networkStateRepository.hideNetworkConnectionError()
        } ?: let { networkStateRepository.showNetworkConnectionError() }
    }

}