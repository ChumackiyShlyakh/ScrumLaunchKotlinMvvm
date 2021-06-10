package com.omnianobis.kotlinmvvmdagger.domain.usercase.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.omnianobis.kotlinmvvmdagger.data.entity.mapper.UiModelMapper
import com.omnianobis.kotlinmvvmdagger.data.entity.presentation.ItemUIModel
import com.omnianobis.kotlinmvvmdagger.domain.repository.IItemsRepository
import com.omnianobis.kotlinmvvmdagger.domain.usercase.BaseObserveUseCase
import javax.inject.Inject

class ObserveItemsUseCase @Inject constructor(
    private val itemsRepository: IItemsRepository
) : BaseObserveUseCase<List<ItemUIModel>>() {

    override fun observe(): LiveData<List<ItemUIModel>> =
        Transformations.map(itemsRepository.observe()) { list -> list.map { UiModelMapper.map(it) } }

}