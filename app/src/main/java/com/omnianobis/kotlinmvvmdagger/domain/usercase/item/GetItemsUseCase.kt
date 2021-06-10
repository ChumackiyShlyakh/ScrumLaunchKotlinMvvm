package com.omnianobis.kotlinmvvmdagger.domain.usercase.item

import com.omnianobis.kotlinmvvmdagger.data.entity.mapper.UiModelMapper
import com.omnianobis.kotlinmvvmdagger.data.entity.presentation.ItemUIModel
import com.omnianobis.kotlinmvvmdagger.domain.repository.IItemsRepository
import com.omnianobis.kotlinmvvmdagger.domain.usercase.BaseCoroutinesUseCase
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val itemsRepository: IItemsRepository
) : BaseCoroutinesUseCase<List<ItemUIModel>>() {

    override suspend fun executeOnBackground(): List<ItemUIModel> =
        itemsRepository.get().map { model -> UiModelMapper.map(model) }
}