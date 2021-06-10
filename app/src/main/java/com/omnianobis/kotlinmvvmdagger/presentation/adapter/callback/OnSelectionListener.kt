package com.omnianobis.kotlinmvvmdagger.presentation.adapter.callback

interface OnSelectionListener<T> {

    fun onItemSelected(item: T?, isChecked: Boolean)
    fun onItemsSelected(items: List<T>)

}