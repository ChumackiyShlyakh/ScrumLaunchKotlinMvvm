package com.omnianobis.kotlinmvvmdagger.presentation.ui.main.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.omnianobis.kotlinmvvmdagger.R
import com.omnianobis.kotlinmvvmdagger.common.Navigate
import com.omnianobis.kotlinmvvmdagger.presentation.ui.BaseFragment
import com.omnianobis.kotlinmvvmdagger.presentation.viewmodel.main.SecondViewModel
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment: BaseFragment() {

    private val viewModel: SecondViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.fragment_second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.apply {
            navigationGlobalEvent.observe(this@SecondFragment, Observer(this@SecondFragment::handleGlobalNavigation))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        f_second_btn_go_second.setOnClickListener { viewModel.onCloseClicked() }
    }

    private fun handleGlobalNavigation(event: Navigate.Global) {
        when(event){
            Navigate.Global.Close -> navigateUp()
            else -> notImplementedToast()
        }
    }
}