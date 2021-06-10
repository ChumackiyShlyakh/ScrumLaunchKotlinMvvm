package com.omnianobis.kotlinmvvmdagger.data.repository

import androidx.lifecycle.LiveData
import com.omnianobis.kotlinmvvmdagger.data.entity.db.ItemDBModel
import com.omnianobis.kotlinmvvmdagger.data.entity.mapper.DbModelMapper
import com.omnianobis.kotlinmvvmdagger.data.network.services.ApiServices
import com.omnianobis.kotlinmvvmdagger.data.storage.database.dao.IItemsDao
import com.omnianobis.kotlinmvvmdagger.domain.repository.IItemsRepository
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices,
    private val itemsDao: IItemsDao
): IItemsRepository {

    override suspend fun get(): List<ItemDBModel> {
        val listItems = apiServices.getListAsync().await()
        itemsDao.insert(listItems.map { model -> DbModelMapper.map(model) })
        return itemsDao.select()
    }

    override suspend fun delete(model: ItemDBModel) {
        itemsDao.delete(model)
    }

    override suspend fun clear() {
        itemsDao.clear()
    }

    override fun observe(): LiveData<List<ItemDBModel>> = itemsDao.observe()
}