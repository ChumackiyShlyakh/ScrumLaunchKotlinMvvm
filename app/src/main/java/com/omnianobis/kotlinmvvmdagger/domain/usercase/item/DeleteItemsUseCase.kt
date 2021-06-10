package com.omnianobis.kotlinmvvmdagger.domain.usercase.item

import com.omnianobis.kotlinmvvmdagger.data.entity.mapper.DbModelMapper
import com.omnianobis.kotlinmvvmdagger.data.entity.presentation.ItemUIModel
import com.omnianobis.kotlinmvvmdagger.domain.repository.IItemsRepository
import com.omnianobis.kotlinmvvmdagger.domain.usercase.BaseCoroutinesUseCase
import javax.inject.Inject

class DeleteItemsUseCase @Inject constructor(
    private val itemsRepository: IItemsRepository
) : BaseCoroutinesUseCase<Unit>() {

    private var model: ItemUIModel? = null

    override suspend fun executeOnBackground() {
        model?.let { itemsRepository.delete(DbModelMapper.map(it)) }
    }

    fun setData(model: ItemUIModel) {
        this.model = model
    }

}