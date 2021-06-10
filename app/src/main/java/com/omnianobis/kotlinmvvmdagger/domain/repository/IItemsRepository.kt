package com.omnianobis.kotlinmvvmdagger.domain.repository

import androidx.lifecycle.LiveData
import com.omnianobis.kotlinmvvmdagger.data.entity.db.ItemDBModel

interface IItemsRepository {

    suspend fun get(): List<ItemDBModel>

    suspend fun delete(model: ItemDBModel)

    suspend fun clear()

    fun observe(): LiveData<List<ItemDBModel>>
}